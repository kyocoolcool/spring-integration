package kyocoolcool;

import kyocoolcool.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PersonRepstory
 * @Description
 *  1.Repository是一個Empty Interface，也是一個標記Interface
 *  2.若我們繼承的接口繼承Repository，則該Interface會被IOC容器識別為Repository Bean，納入到IOC容器中，進而可以在該interface中定義滿足一訂規範的方法
 *  3.實際上，也可以通過@RepositoryDefinition 註解來替代Repository Interface
 *
 *  在Repository子接口中聲明方法:
 *  1.不能隨便，需要符合一定規範
 *  2.查詢方法以 find | read | get 開頭
 *  3.涉及條件查詢時，條件屬性用條件關鍵字連接
 *  4.條件屬性首字母必須大寫
 *  5.支持屬性的關聯查詢，若當前類有符合條件的屬性則優先使用，而不使用關聯屬性
 *  若需要使用關聯屬性，則屬性之間使用 _ 進行連接
 *
 * @Author chris
 * @Date 2019-04-18 23:25
 * @Version 1.0
 **/
//@RepositoryDefinition(domainClass = Person.class,idClass = Integer.class)
public interface PersonRepository extends JpaRepository<Person,Integer> , JpaSpecificationExecutor<Person> ,MyRepository{
    Person getByLastName(String laseName);

    //Where lastName LIKE ? % AND id < ?
    List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, Integer id);

    List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, Integer id);

    //Where email IN (?,?,?) OR birth < ?
    List<Person> getByEmailInOrBirthLessThan(List<String> email, Date birth);

    //Where PersonAddressID > ?
    List<Person> getByAddressIdGreaterThan(Integer id);

    //查詢id值最大的Person
    //使用@Query可以自定義JPQL語句，以實現更靈活的查詢
    @Query("select p from Person p where p.id = (select max(p2.id) from Person p2)")
    Person getMaxIdPerson();

    //為Query註解傳遞參數傳遞方式1，使用佔位符
    @Query("select p from Person p where p.lastName=?1 and p.email=?2")
    List<Person> testQueryAnnotationParam1(String lastName,String email);

    //為Query註解傳遞參數傳遞方式2，命名參數的方式
    @Query("select p from Person p where p.lastName=:lastName and p.email=:email")
    List<Person> testQueryAnnotationParam2( @Param("lastName") String lastName,@Param("email") String email );

    //SpringData允許在佔位符上添加%%
    @Query("select p from Person p where p.lastName like %?1% or p.email like %?2%")
    List<Person> testQueryAnnotationLikeParam(String lastName, String email);

    //SpringData允許在佔位符上添加%%
    @Query("select p from Person p where p.lastName like %:lastName% or p.email like %:email%")
    List<Person> testQueryAnnotationLikeParam2(@Param("lastName") String lastName,@Param("email") String email);

    //設置nativeQuery=true，使用原生的SQL查詢
    @Query(value ="select count(id) from Person",nativeQuery = true)
    long getTotalCount();

    //可以透過JPQL完成update/delete操作，JPQL不支持使用insert
    //@Query中可以定義JPQL但必須加上@Modifying進行修飾，通知SpringData這是update/delete操作
    //update/delete必須使用事務，此時需要定義service層，在service層的方法上添加事務操作
    //默認情況下SpringData每個方法是有事務，但都是只讀事務，不能完成修改操作
    @Modifying
    @Query("update Person p set p.email= :email where id= :id")
    void updatePersonEmail(@Param("email") String email,@Param("id") Integer id);
}
