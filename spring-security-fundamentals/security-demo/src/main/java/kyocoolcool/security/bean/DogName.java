package kyocoolcool.security.bean;

/**
 * @ClassName DogName
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/9/26 6:20 PM
 * @Version 1.0
 **/

public class DogName {
    private String name;

    public DogName() {
    }

    public DogName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DogName{" +
                "name='" + name + '\'' +
                '}';
    }
}