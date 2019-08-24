package kyocoolcool.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName ColorFactoryBean
 * @Description 創建Spring定義的工廠Bean
 * @Author chris
 * @Date 2019-03-19 10:33
 * @Version 1.0
 **/

public class ColorFactoryBean implements FactoryBean<Color> {
    //返回Color對象，並添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean調用getObject");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
    //如果返回是true就是Singleton，在容器中只會保存一份
    //如果是false，就是多實例，每次創建都會產生新的對象
    @Override
    public boolean isSingleton() {
        return false;
    }
}