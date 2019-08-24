package kyocoolcool.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyBeanPostProcess
 * @Description 初始化前後進行處理工作，將後製處理器加到容器中
 * @Author chris
 * @Date 2019-03-20 15:35
 * @Version 1.0
 **/
@Component
public class MyBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization beanName:"+beanName+"->"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization beanName:"+beanName+"->"+bean);
        return bean;
    }
}