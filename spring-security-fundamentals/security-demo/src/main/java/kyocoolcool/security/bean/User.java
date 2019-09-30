package kyocoolcool.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import kyocoolcool.security.vaildator.MyConstraint;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/9/25 7:26 PM
 * @Version 1.0
 **/

public class User {
    private Name name;
    /**
     * 若是Integer or Long 只能用 @NotNull
     * String 可以多@NotBlank,@NotEmpty
     */
//    @NotNull(message = "age can not be empty")
    @MyConstraint(message = "這是測試")//自定義標籤
    private Integer age;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)//回傳long數據
    @Past(message = "生日必須是過去的時間")
    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}