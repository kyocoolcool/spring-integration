package kyocoolcool.DemoConfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @ClassName test1
 * @Description TODO
 * @Author chris
 * @Date 2019-04-10 09:00
 * @Version 1.0
 **/
public class test123 {

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("kyocoolcool.DemoConfig");
    }
}