package kyocoolcool.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Chris Chen
 * @Date 2020/1/5 11:46 PM
 * @Version 1.0
 **/
@Controller
public class LoginController {
    @RequestMapping("/index.html")
    public String first() {
        return "index";
    }

    @RequestMapping("/signIn")
    public String index() {
        return "demo-signIn";
    }

    @RequestMapping("/signIn.html")
    public String signIn() {
        return "signIn";
    }

    @RequestMapping("/demo-signIn")
    public String demoSignIn() {
        return "demo-signIn";
    }
}