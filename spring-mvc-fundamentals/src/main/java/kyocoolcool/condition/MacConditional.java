package kyocoolcool.condition;

import kyocoolcool.bean.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName MacConditional
 * @Description 判斷是否為Mac系統
 * ConditionContext: 判斷條件能使用的(上下文)環境
 * AnnotatedTypeMetadata: 當前標示Condition註解的訊息
 * @Author chris
 * @Date 2019-03-18 17:05
 * @Version 1.0
 **/
public class MacConditional  implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        1.能獲取IOC使用的Bean工廠
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        2.能獲取Class加載器
        ClassLoader classLoader = context.getClassLoader();
//        3.能獲取環境變量
        Environment environment = context.getEnvironment();
//        4.能獲取Bean的註冊類
        BeanDefinitionRegistry registry = context.getRegistry();
        //判斷容器中bean的註冊情形，也可以給容器註冊bean
//        boolean person = registry.containsBeanDefinition("person");
        BeanDefinition person2 = registry.getBeanDefinition("person");
        registry.registerBeanDefinition("person2",person2);
        String property = environment.getProperty("os.name");
        if(property.contains("Mac"))
            return true;
        return false;
    }
}