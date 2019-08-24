package kyocoolcool;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

/**
 * @ClassName MyRepositoryImpl
 * @Description 實作MyRepository
 * @Author chris
 * @Date 2019-04-21 13:04
 * @Version 1.0
 **/

public class MyRepositoryImpl implements MyRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void test() {
        Person person = entityManager.find(Person.class, 48);
        System.out.println("Person: "+person);
    }
}