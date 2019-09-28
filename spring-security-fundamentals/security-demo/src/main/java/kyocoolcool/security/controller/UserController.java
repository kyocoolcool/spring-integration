package kyocoolcool.security.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kyocoolcool.security.bean.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    //@PageableDefault(page = 10,size = 20,sort = "name,asc") Pageable pageable 若沒有傳size,page,sort參數，預設數值
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> query(Person person, @PageableDefault(page = 10, size = 20, sort = "name,asc") Pageable pageable) {
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

    /**
     * {id:\d+} 正則表達式，只接收數字
     */
    @RequestMapping(path = "/user/{id:\\d+}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        System.out.println(id);
        User user = new User(new Name("Chris", "Chen"), 20);
        System.out.println(user);
        return user;
    }

    /*
     * @description: @JsonView 使用範例，來選擇回傳哪些屬性
     * @param
     * @return: java.util.List<kyocoolcool.security.bean.Person>
     * @author: Chris Chen
     * @time: 2019/9/28 3:50 PM
     */
    @RequestMapping(path = "/person", method = RequestMethod.GET)
    @JsonView(Person.UserSimpleView.class)
    public List<Person> queryByJsonViewBySimple() {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Chris", 20));
        persons.add(new Person("Wang", 10));
        persons.add(new Person("Da", 30));
        return persons;
    }

    /*
     * @description: 必須定義回傳哪一個view，若沒定義就直接回傳所有的屬性
     * @param id
     * @return: kyocoolcool.security.bean.Person
     * @author: Chris Chen
     * @time: 2019/9/28 3:49 PM
     */
    @RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
    @JsonView(Person.UserDetailView.class)
    public Person queryByJsonViewByDetail(@PathVariable String id) {
        System.out.println("接收的路徑變數:" + id);
        Person person = new Person("Da", 30);
        return person;
    }

}