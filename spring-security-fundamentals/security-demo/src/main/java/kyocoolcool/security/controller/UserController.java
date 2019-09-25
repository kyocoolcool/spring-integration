package kyocoolcool.security.controller;

import kyocoolcool.security.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description 回傳json
 * @Author Chris Chen
 * @Date 2019/9/24 11:34 PM
 * @Version 1.0
 **/
@RestController
public class UserController {

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> query() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("chris", 20));
        users.add(new User("Nick", 30));
        users.add(new User("Ann", 40));
        return users;
    }

}