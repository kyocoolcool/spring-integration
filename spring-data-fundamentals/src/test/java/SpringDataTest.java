import kyocoolcool.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SpringDataTest
 * @Description SpringData測試
 * @Author chris
 * @Date 2019-04-18 14:53
 * @Version 1.0
 **/

public class SpringDataTest {
    private ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    private PersonRepository personRepository=ctx.getBean(PersonRepository.class);
    private PersonService personService = ctx.getBean(PersonService.class);
    private AddressRepository addressRepository=ctx.getBean(AddressRepository.class);
    private AddressService addressService = ctx.getBean(AddressService.class);

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource=ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testHelloWorldSpringData(){

    }

    @Test
    public void testJpa(){
        Person person = personRepository.getByLastName("Chen");
        System.out.println(person);
    }

    @Test
    public void testKeyWords1(){
        List<Person> persons = personRepository.getByLastNameStartingWithAndIdLessThan("Ch", 5);
        System.out.println(persons);
    }

    @Test
    public void testKeyWords2(){
        List<Person> persons = personRepository.getByLastNameEndingWithAndIdLessThan("hen", 10);
        System.out.println(persons);
    }

    @Test
    public void testKeywords3(){
        List<Person> persons = personRepository.getByEmailInOrBirthLessThan(Arrays.asList("kyocoolcool@gmail.com", "hello@gmail.com", "apple@gmail.com"), new Date());
        System.out.println(persons);
    }

    @Test
    public void testKeywords4(){
        List<Person> persons = personRepository.getByAddressIdGreaterThan(0);
        System.out.println(persons);
    }

    @Test
    public void testQueryAnnotation(){
        Person person = personRepository.getMaxIdPerson();
        System.out.println(person);
    }

    @Test
    public void testQueryAnnotationParam1(){
        List<Person> persons = personRepository.testQueryAnnotationParam1("Chen", "kyocoolcool@hotmail.com");
        System.out.println(persons);
    }

    @Test
    public void testQueryAnnotationParam2(){
        List<Person> persons = personRepository.testQueryAnnotationParam2("Chen", "kyocoolcool@hotmail.com");
        System.out.println(persons);
    }

    @Test
    public void testQueryAnnotationLikeParam(){
        List<Person> persons = personRepository.testQueryAnnotationLikeParam("Ch", "@gmail.com");
        System.out.println(persons.size());
    }

    @Test
    public void testQueryAnnotationLikeParam2(){
        List<Person> persons = personRepository.testQueryAnnotationLikeParam2("Ch", "@gmail.com");
        System.out.println(persons.size());
    }

    @Test
    public void testNativeQuery(){
        long count = personRepository.getTotalCount();
        System.out.println(count);
    }

    @Test
    public void testModifying(){
        personService.updatePersonEmail("kyocoolcool@gmail.com",1);
    }

    @Test
    public void testCrudRepository(){
        List<Person> persons = new ArrayList<>();
        for(int i='a';i<'z';i++){
            Person person = new Person();
            person.setLastName((char)i+""+(char)i);
            person.setEmail((char)i+""+(char)i+"@gmail.com");
            person.setBirth(new Date());
//            person.setAddress(new Address(1,"taiwan","taipei"));
            persons.add(person);
        }
        personService.savePersons(persons);
    }

    @Test
    public void testCrudRepository2(){
            Person person = new Person();
//            person.setId(6);
            person.setLastName((char)'a'+""+(char)'a');
            person.setEmail((char)'a'+""+(char)'a'+"@gmail.com");
            person.setBirth(new Date());
        personService.savePerson(person);
    }

    @Test
    public void testPagingAndSortingRepository(){
        //當前頁從0開始
        int pageNo=2-1;
        int size=5;
        //Pageable interface通常使用PageRequest實現類，其中封裝了分頁的訊息
        //sort封裝排序的訊息
        //order具體是針對某一屬性進行升降冪排列
        //Order已經Deprecate
//        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "id");
//        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "email");
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        //PageRequest已經Deprecate
//        PageRequest pageRequest = new PageRequest(pageNo, size,sort);
        PageRequest pageRequest = PageRequest.of(pageNo, size, sort);
        Page<Person> personPage = personRepository.findAll(pageRequest);
        System.out.println("總記錄數: "+personPage.getTotalElements());
        System.out.println("當前第幾頁: "+(personPage.getNumber()+1));
        System.out.println("總頁數: "+personPage.getTotalPages());
        System.out.println("當前頁面的紀錄數: "+personPage.getNumberOfElements());
        List<Person> content = personPage.getContent();
        content.forEach(System.out::print);
    }

    //saveAndFlush是merge的概念
    @Test
    public void testJpaRepository(){
        Person person = new Person();
        person.setLastName("Bang");
        person.setBirth(new Date());
        person.setEmail("bang@hotmail.com");
//        person.setId(56);
        personRepository.saveAndFlush(person);
    }

    /**
     * @Author chris
     * @Description //目標:實現帶查詢條件的分頁 id>5
     * Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable);
     * Specification:封裝了JPA Criteria 查詢條件
     * PageRequest封裝了查詢分頁訊息:pageNo,pageSize,sort
     * @Date 17:00 2019-04-20
     * @Param
     * @return void
     **/
    @Test
    public void testJpaSpecificationExecutor(){
        int pageNo=1-1;
        int pageSize=5;
        //通常使用Specification的匿名內部類
        Specification<Person> specification= new Specification<Person>() {

            /**
             * @Author chris
             * @Description JpaSpecificationExecutor操作
             * @Date 17:15 2019-04-20
             * @Param root:代表查詢的實體類
             * @Param query:可以從中得到root對象，既可以告知JPA Criteria 要查詢的類，還可以來添加查詢條件，還可以結合Entity對象得到最終查詢的TypeQuery對象，
             * @Param criteriaBuilder:CriteriaBuilder對象，用於創建Criteria 相關對象的工廠，可以從中獲取到Predicate對象
             * @return javax.persistence.criteria.Predicate:代表一個查詢條件
             **/
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("id");
                Predicate predicate = criteriaBuilder.gt(path, 55);
                return predicate;
            }
        };
        PageRequest pageRequest = new PageRequest(pageNo, pageSize);
        Page<Person> personPage = personRepository.findAll(specification, pageRequest);
        System.out.println("總記錄數: "+personPage.getTotalElements());
        System.out.println("當前第幾頁: "+(personPage.getNumber()+1));
        System.out.println("總頁數: "+personPage.getTotalPages());
        System.out.println("當前頁面的紀錄數: "+personPage.getNumberOfElements());
        List<Person> content = personPage.getContent();
        System.out.println(content);
    }

    @Test
    public void testMyRepositoryMethod(){
        personRepository.test();
    }

    @Test
    public void testRel(){
        Person person = new Person();
        person.setBirth(new Date());
        person.setEmail("333@qq.com");
        person.setLastName("ccc");
        Address address = new Address();
        address.setCity("QQ");
        address.setProvince("QQ");
//        address.setId(2);
        Person person2 = new Person();
        person2.setBirth(new Date());
        person2.setEmail("QQQ@qq.com");
        person2.setLastName("QQQ");
        address.getPerson().add(person);
        address.getPerson().add(person2);
        person.setAddress(address);
        person2.setAddress(address);
        personRepository.saveAndFlush(person);
    }

    @Test
    public void testRel2(){
        Person person = new Person();
        person.setBirth(new Date());
        person.setEmail("333@qq.com");
        person.setLastName("ccc");
        Address address = new Address();
        address.setId(8);
        address.setCity("QQ");
        address.setProvince("QQ");
        address.getPerson().add(person);
        person.setAddress(address);
        addressRepository.saveAndFlush(address);
    }
}