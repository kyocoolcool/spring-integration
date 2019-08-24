package kyocoolcool.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author chris
 * @Date 2019-03-20 11:17
 * @Version 1.0
 **/
@Component
public class Dog implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    public Dog() {
        System.out.println("Dog @PostConstruc..");
    }
//    對象創建及賦值後調用
    @PostConstruct
    public void init (){
        System.out.println("Dog constructor..");
    }
//    對象銷毀之前調用
    @PreDestroy
    public void destroy(){
        System.out.println("Dog @PreDestroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}