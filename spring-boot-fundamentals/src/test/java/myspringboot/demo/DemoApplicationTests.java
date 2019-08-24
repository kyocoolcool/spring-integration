package myspringboot.demo;

import myspringboot.demo.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    User user;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void helloService(){
       Boolean b= ioc.containsBean("helloService1");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
        logger.info(user.toString());
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

}

