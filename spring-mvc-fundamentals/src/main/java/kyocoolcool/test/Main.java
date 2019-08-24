package kyocoolcool.test;

import kyocoolcool.config.MainConfig;
import kyocoolcool.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description 測試類
 * @Author chris
 * @Date 2019-03-17 07:16
 * @Version 1.0
 **/

public class Main {
    public static void main(String[] args) {
/** xml測試方法 **/
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = applicationContext.getBean(Person.class);
//        System.out.println(person);

/** 註解測試方法 **/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }

    }
}