package myspringboot.demo.controller;

import myspringboot.demo.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HelloWorld
 * @Description Spring MVC 請求參數傳遞
 * @Author chris
 * @Date 2019-01-19 13:58
 * @Version 1.0
 **/
//@Controller
//@RestController
public class HelloController {
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello SpringBoot";
    }

    @GetMapping(value = "/hello/{name}")
    public String helloName(@PathVariable("name") String name){
        System.out.println("Name:" + name);
        return "Hello "+ name;
    }

    /**
     * @Author chris
     * @Description 若request/?參數->name (與參數相同)可省略RequestParam,
     * 但注意若加上RequestParam,則必須有請求參數否則會報400錯誤,也可使用
     * defaultValue = "admin"預設的參數,或者required = false
     * @Date 15:45 2019-01-19
     * @Param String
     * @return java.lang.String
     **/
    @GetMapping(value = "/hello2")
    public String hello(@RequestParam(value = "name",defaultValue = "admin",required = false) String name){
        System.out.println("Name:" + name);
        return "Hello "+ name;
    }

    @GetMapping(value = "/hello3")
    public String hello3(String name){
        System.out.println("Name:" + name);
        return "Hello "+ name;
    }

    @GetMapping(value = "/hello4")
    public String hello4(@RequestParam(value = "name",required = false) String name){
        System.out.println("Name:" + name);
        return "Hello "+ name;
    }

    @PostMapping(value = "/hello5")
    public String hello5(String name,Integer age){
        return "name: "+name+" age: "+age;
    }

    @PostMapping
    public Map<String,Object> user(@RequestBody User user){
        Map<String,Object> userMap=new HashMap<String, Object>();
            userMap.put("user",user);
        return userMap;
    }

    @PostMapping(value="/postString")
    public String postString(HttpServletRequest request){
        ServletInputStream is=null;
        StringBuilder sb=null;

        try {
            is=request.getInputStream();
            sb=new StringBuilder();
            byte[] buf=new byte[1024];
           int len=0;
           while ((len= is.read(buf))!=-1){
               sb.append(new String(buf,0,len));
           }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is !=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }


}