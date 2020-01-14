package kyocoolcool.security.core.validate.code;

import kyocoolcool.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ValidateCodeBeanConfig
 * @Description TODO
 * @Author Chris Chen
 * @Date 2020/1/13 2:07 PM
 * @Version 1.0
 **/
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    //系統啟動時會在容器找imageCodeGenerator bean ，若找到則不會執行此段代碼。
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }
}