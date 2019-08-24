package kyocoolcool;

import kyocoolcool.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName IocTestLifeCycle
 * @Description TODO
 * @Author chris
 * @Date 2019-03-19 11:12
 * @Version 1.0
 **/

public class IocTestLifeCycle {
    //創建IOC容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
    @Test
    public void test01(){
        System.out.println("容器創建完成");
        Object bean = applicationContext.getBean("car");

        applicationContext.close();
    }

}