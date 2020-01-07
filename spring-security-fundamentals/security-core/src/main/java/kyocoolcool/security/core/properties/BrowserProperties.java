package kyocoolcool.security.core.properties;

/**
 * @ClassName BrowserProperties
 * @Description Browser配置
 * @Author Chris Chen
 * @Date 2020/1/7 10:08 AM
 * @Version 1.0
 **/

public class BrowserProperties {
    private String loginPage; //預設路徑

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}