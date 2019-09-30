package kyocoolcool.security.service.impl;

import kyocoolcool.security.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloServiceImpl
 * @Description 自定義Bean
 * @Author Chris Chen
 * @Date 2019/9/30 1:53 PM
 * @Version 1.0
 **/
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello " + name;
    }
}