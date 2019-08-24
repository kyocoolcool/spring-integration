package myspringboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName SayHello
 * @Description TODO
 * @Author chris
 * @Date 2019-01-30 20:09
 * @Version 1.0
 **/
//@RestController
    @Controller
public class SayHelloController {

//    @Value("${user.dog.name}")
    private String name;

    @ResponseBody
    @RequestMapping("/sayHello")
    public String sayHello(){
    return "Hi  "+name;
    }

    @RequestMapping("/success")
    public String wellcome(Map<String,Object> map) {
        map.put("hello","<h1>hello</h1>");
        map.put("users",Arrays.asList("Nick","Neil","Jeff"));
        map.put("name","Chris");
        return "success";
    }

    @RequestMapping(value = "/table")
    public String table(){
        return "table";
    }

//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "index";
//    }
}