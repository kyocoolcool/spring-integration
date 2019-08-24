package myspringboot.demo.bean;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author chris
 * @Date 2019-01-30 19:15
 * @Version 1.0
 **/

public class Dog {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}