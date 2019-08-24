package kyocoolcool.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author chris
 * @Date 2019-03-19 19:09
 * @Version 1.0
 **/
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("Cat constructor..");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat destroy..");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat afterPropertiesSet..");

    }
}