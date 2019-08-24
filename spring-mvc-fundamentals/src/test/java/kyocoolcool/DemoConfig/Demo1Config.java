package kyocoolcool.DemoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @ClassName Demo1Config
 * @Description TODO
 * @Author chris
 * @Date 2019-04-10 09:23
 * @Version 1.0
 **/
@Configuration
@Order(2)
public class Demo1Config {
    public Demo1Config() {
        System.out.println("Demo1Config");
    }

    @Bean
    public void demo1Service() {
        System.out.println("demo1config 加载了");
    }
}