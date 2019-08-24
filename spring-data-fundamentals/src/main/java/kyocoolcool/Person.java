package kyocoolcool;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName Person
 * @Description Entity
 * @Author chris
 * @Date 2019-04-18 17:17
 * @Version 1.0
 **/

@Entity
@Table(name="Person")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String lastName;
    private String email;
    private Date birth;

    @ManyToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "address_id")
    private Address address;

    public Person() {
    }

    public Person(Integer id, String lastName, String email, Date birth) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email) &&
                Objects.equals(birth, person.birth) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, email, birth, address);
    }
}