package kyocoolcool.security.bean;

import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/9/25 7:26 PM
 * @Version 1.0
 **/

public class Bag {
    private List<String> name;
    private Integer age;

    public Bag() {
    }

    public Bag(List<String> name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
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
        return "Bag{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}