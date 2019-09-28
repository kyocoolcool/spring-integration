package kyocoolcool.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /*
     * @description: 用Get方式
     * @param
     * @return: void
     * @author: Chris Chen
     * @time: 2019/9/26 5:47 PM
     */
    @Test
    public void whenQuerySuccessByRequest() throws Exception {
        mockMvc.perform(get("/user")
                .param("name", "Chris")
                .param("age", "18")
//                .param("size", "15")
//                .param("page", "3")
//                .param("sort", "age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));

    }

    /*
     * @description: 用Post方式
     * @param
     * @return: void
     * @author: Chris Chen
     * @time: 2019/9/26 5:48 PM
     */
    @Test
    public void whenQuerySuccessByPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user2")
                .content("[{\"name\":{\"firstName\":\"Ann\",\"lastName\":\"Chen\"},\"age\":10},{\"name\":{\"firstName\":\"Nick\",\"lastName\":\"Lee\"},\"age\":18},{\"name\":{\"firstName\":\"Peter\",\"lastName\":\"Wang\"},\"age\":38}]")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    /*
     * @description: 傳List<String>參數
     * @param
     * @return: void
     * @author: Chris Chen
     * @time: 2019/9/26 7:14 PM
     */
    @Test
    public void whenQuerySuccessByRequest4() throws Exception {
        mockMvc.perform(get("/user4")
                .param("name", "Chris", "Mine")
                .param("age", "18")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        mockMvc.perform(get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name.firstName").value("Chris"));

    }

    /*
     * @description: 傳送不接收的數據類型
     * @param
     * @return: void
     * @author: Chris Chen
     * @time: 2019/9/28 3:09 PM
     */
    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(get("/user/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError());
    }

    /*
     * @description: 使用jsonView simpleView僅回傳name
     * @param
     * @return: void
     * @author: Chris Chen
     * @time: 2019/9/28 3:43 PM
     */
    @Test
    public void testJsonViewBySimple() throws Exception {
        String result = mockMvc.perform(get("/person")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result:" + result);
    }

    /*
     * @description: 使用jsonView detailView回傳詳細資訊包含age
     * @param
     * @return: void
     * @author: Chris Chen
     * @time: 2019/9/28 3:48 PM
     */
    @Test
    public void testJsonViewByDetail() throws Exception {
        String result = mockMvc.perform(get("/person/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result:" + result);
    }
}