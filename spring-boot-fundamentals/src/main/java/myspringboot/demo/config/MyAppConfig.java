package myspringboot.demo.config;

import myspringboot.demo.component.MyLocalResolve;
import myspringboot.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @ClassName MyAppConfig
 * @Description TODO
 * @Author chris
 * @Date 2019-01-31 10:47
 * @Version 1.0
 **/

@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService1(){
        return new HelloService();
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolve();
    }
}