package kyocoolcool.security.bean;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @ClassName User
 * @Description jsonView須加在get方法上
 * @Author Chris Chen
 * @Date 2019/9/25 7:26 PM
 * @Version 1.0
 **/

public class Person {
    public interface UserSimpleView {
    }

    ;

    public interface UserDetailView extends UserSimpleView {
    }

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @JsonView(UserSimpleView.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(UserDetailView.class)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}