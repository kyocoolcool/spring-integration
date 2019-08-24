package kyocoolcool.condition;

import kyocoolcool.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportBeanDefinitionRegister
 * @Description TODO
 * @Author chris
 * @Date 2019-03-19 10:03
 * @Version 1.0
 **/

public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    /**
     * @Author chris
     * @Description
     * AnnotationMetadata:當前類的註解情形
     * BeanDefinitionRegistry:把所有需要添加到容器中的Bean註冊進去
     * 調用BeanDefinitionRegistry.registerBeanDefinition手動註冊
     * @Date 10:04 2019-03-19
     * @Param
     * @return void
     **/
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("kyocoolcool.bean.Red");
        boolean blue = registry.containsBeanDefinition("kyocoolcool.bean.Bule");
        //指定Bean的訊息
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
        if(red&&blue)
        //註冊Bean及指定Bean名
        registry.registerBeanDefinition("rainBow",rootBeanDefinition);
    }
}