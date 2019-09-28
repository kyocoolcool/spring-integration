package kyocoolcool.security.bean;

/**
 * @ClassName User
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/9/25 7:26 PM
 * @Version 1.0
 **/

public class User {
    private Name name;
    private Integer age;

    public User() {
    }

    public User(Name name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}