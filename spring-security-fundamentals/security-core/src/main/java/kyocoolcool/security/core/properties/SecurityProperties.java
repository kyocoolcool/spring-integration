package kyocoolcool.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecurityProperties
 * @Description 封裝配置
 * @Author Chris Chen
 * @Date 2020/1/7 10:07 AM
 * @Version 1.0
 **/

@Component
@ConfigurationProperties(prefix = "kyocoolcool.security")
public class SecurityProperties {
    private BrowserProperties browserProperties=new BrowserProperties();

    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties=browserProperties;
    }

    public void setLoginPage(String loginPage) {
        this.browserProperties.setLoginPage(loginPage);
    }

}