package kyocoolcool.config;

import kyocoolcool.bean.Car;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @see Car
 * Demo 容器管理bean的生命週期bean為:{@link Car}
 * @ClassName MainConfigOfLifeCycle
 * @Description Bean的生命週期:
 * 創建----初始化----銷毀
 * 容器管理bean生命週期:
 * 我們可以自定義初始化和銷毀方法,容器在bean進行到當前生命週期時，會調用我們自定義的初始化及銷毀方法
 * 1.指定初始化和銷毀方法init-method="" destroy-method=""
 *      構造:
 *          單實例:容器在啟動時創建對象
 *          多實例:獲取時才創建對象
 *      初始化:
 *          對象創建好，並賦值好調用初始化方法
 *      銷毀:
 *          單實例bean:容器關閉時進行銷毀
 *          多實例bean:容器不會管理該bean調用銷毀方法
 * 2.通過Bean實現InitializingBean(定義初始化邏輯){@link InitializingBean}，
 *   通過Bean實現DisposableBean(定義銷毀邏輯)
 * 3.使用JSR250:
 *          @PostConstructor:bean創建完成並且屬性賦值完成，來執行初始化方法
 *          @PreDestroy:在容器銷毀之前，進行清理工作
 * 4.@BeanProcess:Bean的後製處理器:在bean的初始化前後進行處理工作
 *          postPrecessBeforeInitialization:初始化之前工作
 *          postPrecessAfterInitialization:初始化之後工作
 * 遍歷得到容器中所有的BeanPostProcessor,一個個執行beforeInitialization
 * 一但返回null，跳出for循環，不會執行後面的BeanPostProcessor.postProcessors
 * populateBean(beanName,mbd,instanceWrapper):給bean屬性賦值
 * initializeBean{
 *     applyBeanPostProcessBeforeInitialization
 *     invokeInitMethods(beanName,wrapperBean,mbd):執行初始化
 *     applyBeanPostProcessAfterInitialization
 * }
 * Spring底層對BeanPostProcessor:
 *     Bean賦值,其他組件注入,@Autowired,生命週期註解功能,@Async....都是由Spring底層對BeanPostProcessor完成
 *
 *
 * @Author chris
 * @Date 2019-03-19 11:03
 * @Version 1.0
 **/
@ComponentScan("kyocoolcool")
@Configuration
public class MainConfigOfLifeCycle {
    @Scope("singleton")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}