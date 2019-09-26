package kyocoolcool.security.controller;

import kyocoolcool.security.bean.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
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


    //@RequestParam(required = false,defaultValue = "Tom") String userName 可以利用此參數，預設數值及非強制傳遞
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> query(Person person, Pageable pageable) {
        System.out.println(pageable);
        System.out.println(ReflectionToStringBuilder.toString(person));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(new Name("a", "a"), 10));
        users.add(new User(new Name("b", "b"), 20));
        users.add(new User(new Name("c", "c"), 30));
        return users;
    }

    @RequestMapping(path = "/user2", method = RequestMethod.POST)
    public List<User> query2(@RequestBody(required = false) List<User> users) {
        System.out.println(users);
        return users;
    }

    @RequestMapping(path = "/user3", method = RequestMethod.GET)
    public List<User> query3(Animal animal) {
        System.out.println(animal);
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(new Name("a", "a"), 10));
        users.add(new User(new Name("b", "b"), 20));
        users.add(new User(new Name("c", "c"), 30));
        return users;
    }

    @RequestMapping(path = "/user4", method = RequestMethod.GET)
    public List<User> query4(Bag bag) {
        System.out.println(bag);
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(new Name("a", "a"), 10));
        users.add(new User(new Name("b", "b"), 20));
        users.add(new User(new Name("c", "c"), 30));
        return users;
    }

}