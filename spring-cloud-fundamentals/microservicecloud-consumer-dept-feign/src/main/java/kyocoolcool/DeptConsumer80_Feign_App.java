package kyocoolcool;

import IRuleConfig.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName DeptConsumer80_App
 * @Description TODO
 * @Author chris
 * @Date 2019-02-23 22:59
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"kyocoolcool"})
@RibbonClient(name = "microservicecloud-dept",configuration = MyselfRule.class)
public class DeptConsumer80_Feign_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}