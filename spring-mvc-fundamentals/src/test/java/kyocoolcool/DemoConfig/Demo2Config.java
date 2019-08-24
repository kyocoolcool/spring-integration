package kyocoolcool.DemoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @ClassName Demo2Config
 * @Description TODO
 * @Author chris
 * @Date 2019-04-10 09:23
 * @Version 1.0
 **/
@Configuration
@Order(1)
public class Demo2Config {
    public Demo2Config() {
        System.out.println("Demo2Config");
    }

    @Bean
    public void demo2Service() {
        System.out.println("demo2config 加载了");
    }
}