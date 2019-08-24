package kyocoolcool;

import kyocoolcool.bean.Person;
import kyocoolcool.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Date;
import java.util.Map;

/**
 * @see <a href="http://kyocoolcool.nctu.me/">http://kyocoolcool.nctu.me/</a>
 * @ClassName IocTest
 * @Description TODO
 * @Author chris
 * @Date 2019-03-17 08:12
 * @Version 1.0
 **/
public class IocTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void test01(){

        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test02(){

        String[] names = applicationContext.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
        System.out.println("IOC容器創建完成");
        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person==person2);
    }

    @Test
    public void test03(){
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //獲取環境變量的值
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        String property2 = environment.getProperty("java.version");
        System.out.println(property);
        System.out.println(property2);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }
    @Test
    public void importTest() {
        printBeans(applicationContext);
    }

    public void printBeans(ApplicationContext applicationContext )  {
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
        //工廠Bean獲取的是getObject對象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("colorFactoryBean");
        System.out.println("Bean的type:"+bean2.getClass());
        System.out.println(bean2==bean3);
        //直接獲取BeanFactory
        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }
/**
 * @Author chris
 * @Description //TODO 
 * @Date 15:59 2019-03-22
 * @Param 
 * @return void
 **/
    public void test04(){
        Date date = new Date();
        System.out.println("hhhhhhhhhhh");

    }


}