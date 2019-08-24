package kyocoolcool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName kyocoolcool.DeptProvider8001_App
 * @Description TODO
 * @Author chris
 * @Date 2019-02-23 14:31
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProvider8003_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8003_App.class, args);
    }
}