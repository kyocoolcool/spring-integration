package kyocoolcool.config;

import kyocoolcool.bean.Color;
import kyocoolcool.bean.ColorFactoryBean;
import kyocoolcool.bean.Person;
import kyocoolcool.bean.Red;
import kyocoolcool.condition.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @ClassName MainConfig2
 * @Description TODO
 * @Author chris
 * @Date 2019-03-18 13:14
 * @Version 1.0
 **/
/**
 * 給容器註冊組件
 * 1.包掃描+組建註解(@Component,@Service,@Repository,@Controller):自己寫的Class
 * 2.@Bean:導入第三方包裡面的組件
 * 3.@Import:快速給容器中導入一個組件
 *         @Import:(要導入到容器中的組件):容器中就會註冊這組件，id默認是全類名
 *         @ImportSelect:返回需要導入組件的全類名
 *         @ImportBeanDefinitionRegistrar:手動註冊Bean到容器中
 * 4.使用Spring提供的FactoryBean(工廠Bean):
 *         1.默認是工廠Bean調用getObject創建的對象
 *         2.獲取工廠Bean本身，需要在id前加"&"，EX:&colorFactoryBean
 **/
//滿足當前條件,這個Class才配置所有Bean的註冊
//@Conditional({MacConditional.class})
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
@Configuration
public class MainConfig2 {
    //默認是Singleton
   /** @see ConfigurableBeanFactory#SCOPE_PROTOTYPE: prototype
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON: singleton
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST: Web環境下的request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION: Web環境下的session
     * PROTOTYPE: 多實例的 IOC容器啟動時並不會調用方法對象放到容器中，每次獲取時才會創建對象
     * SINGLETON: 單實例的 IOC容器啟動時會調用方法創建對象放到IOC容器中，以後每次獲取直接從容器中拿
     * REQUEST: 同一個request創建一個實例
     * SESSION: 同一個session創建一個實例
     * Lazey加載: 容器啟動不創建對象，第一次獲取bean才創建對象，並進行初始化(針對singleton)
    **/
//    @Scope("prototype")
    @Lazy
    @Bean
    public Person person(){
        System.out.println("給容器添加Person");
        return new Person("nick",18);
    }
/**
 * @Conditional: 按照一定條件進行判斷，滿足條件給容器中註冊Bean
 * 如果系統是Windows就給容器中註冊@Bean("bill")
 * 如果系統是Linux就給容器中註冊@Bean("linus")
 **/
    @Conditional(WindowsConditional.class)
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }
    @Conditional(LinuxConditional.class)
    @Bean("linus")
    public Person person02(){
        return new Person("Linus",48);
    }
    @Conditional({MacConditional.class})
    @Bean("mac")
    public Person person03(){
        return new Person("Jobs",55);
    }
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }


}