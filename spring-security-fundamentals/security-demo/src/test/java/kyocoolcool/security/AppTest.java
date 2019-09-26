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
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("name", "Chris")
                .param("age", "18")
                .param("size", "15")
                .param("page", "3")
                .param("sort", "age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
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
                .andExpect(MockMvcResultMatchers.status().isOk())
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
        mockMvc.perform(MockMvcRequestBuilders.get("/user4")
                .param("name", "Chris", "Mine")
                .param("age", "18")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }
}
