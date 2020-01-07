package kyocoolcool.security.core;

import kyocoolcool.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SecurityCoreConfig
 * @Description 啟動配置
 * @Author Chris Chen
 * @Date 2020/1/7 10:30 AM
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties(value = {SecurityProperties.class})
public class SecurityCoreConfig {
}