package myspringboot.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

/**
 * @ClassName User
 * @Description TODO
 * @Author chris
 * @Date 2019-01-19 17:39
 * @Version 1.0
 **/
//如果不是全域設定可以單獨導入屬性檔
//@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "user")
//@Validated
//支持validated
//也可以用value來取代包含${key}用來取環境變量或配置文件的值 #{SpEL}寫法
public class User {
//    @Value("${user.name}")
//    @Email
    private String name;
//    @Value("#{20*10}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Map<String ,Object> maps;
    private List<Object> lists;
    private Dog dog;

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

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}