package kyocoolcool.security.bean;

/**
 * @ClassName User
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/9/25 7:26 PM
 * @Version 1.0
 **/

public class Animal {
    private DogName name;
    private Integer age;

    public Animal() {
    }

    public Animal(DogName name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public DogName getName() {
        return name;
    }

    public void setName(DogName name) {
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
        return "Animal{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}