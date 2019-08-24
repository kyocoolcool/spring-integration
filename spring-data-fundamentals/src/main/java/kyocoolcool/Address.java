package kyocoolcool;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Address
 * @Description Entity
 * @Author chris
 * @Date 2019-04-19 14:28
 * @Version 1.0
 **/
@Table(name = "Address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String province;
    private String city;

    @OneToMany(mappedBy = "address",cascade =CascadeType.ALL )
    private Set<Person> person = new HashSet<Person>();

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    public Address() {
    }

    public Address(Integer id, String province, String city) {
        this.id = id;
        this.province = province;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}