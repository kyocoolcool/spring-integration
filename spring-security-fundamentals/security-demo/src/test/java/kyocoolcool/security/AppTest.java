package kyocoolcool.security;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        Date date = new Date();
        long time = date.getTime();//時間參數，一般建議傳long數據，比較單純，若前端需要多種格式，可以自行轉換()，較少定義接收格式
        System.out.println(time);
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user2")
                .content("[{\"name\":{\"firstName\":\"Ann\",\"lastName\":\"Chen\"},\"age\":10,\"birthday\":" + time + "},{\"name\":{\"firstName\":\"Nick\",\"lastName\":\"Lee\"},\"age\":18},{\"name\":{\"firstName\":\"Peter\",\"lastName\":\"Wang\"},\"age\":38}]")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(mvcResult);
    }

    /*
     * @description: 操作請求必要age屬性為空或null的請求
     * @param
     * @return: void
     * @author: Chris Chen
     * @time: 2019/9/29 4:53 PM
     */
    @Test
    public void whenQuerySuccessByPost2() throws Exception {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user5")
                .content("{\"name\":{\"firstName\":\"Ann\",\"lastName\":\"Chen\"},\"birthday\":" + time + "}")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(mvcResult);
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

    @Test
    public void whenQuerySuccessByPut() throws Exception {
        Date date = DateUtils.addYears(new Date(), 1);
//        Date date = new Date(LocalDateTime.now().plusYears(1).toLocalDate().getLong();
        System.out.println(date.getTime());
        long time = date.getTime();
        System.out.println(time);
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                .content("{\"name\":{\"firstName\":\"Ann\",\"lastName\":\"Chen\"},\"age\":\"20\",\"birthday\":" + time + "}")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(mvcResult);
    }

    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    /*
     * @description: 上傳檔案測試
     * @param
     * @return: void
     * @author: Chris Chen
     * @time: 2019/10/22 4:57 PM
     */
    @Test
    public void whenUploadSuccess() throws Exception {
        String result = mockMvc.perform(multipart("/file")
                .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "Hello uplad".getBytes("UTF-8"))))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
}
