package kyocoolcool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName kyocoolcool.EurekaServer7001_App
 * @Description TODO
 * @Author chris
 * @Date 2019-02-24 10:58
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class Config_Git_EurekaSerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaSerApplication.class, args);
    }
}