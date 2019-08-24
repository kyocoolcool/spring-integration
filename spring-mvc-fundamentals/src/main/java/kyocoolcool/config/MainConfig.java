package kyocoolcool.config;

import kyocoolcool.bean.Person;
import kyocoolcool.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @ClassName MainConfig
 * @Description 配置類=xml配置文件
 * @Author chris
 * @Date 2019-03-17 07:24
 * @Version 1.0
 **/
@Configuration //告訴Spring這是一個配置類
//@ComponentScans({@ComponentScan(value = "kyocoolcool")})
@ComponentScan(value = "kyocoolcool",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = BookService.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})}
        ,useDefaultFilters = false)
/**@ComponentScans: 可容納多個@ComponentScan 規則
@ComponentScan value: 指定要掃描的包
excludeFilters =  @ComponentScan.Filter []: 指定掃描的時候按照定義規則排除組件
includeFilters =  @ComponentScan.Filter []: 指定掃描的時候按照定義規則注入組件
FilterType.ANNOTATION: 按照給定的註解
FilterType.ASSIGNABLE_TYPE: 按照給定的類型
FilterType.ASPECTJ: 使用ASPECTJ表達式
FilterType.REGEX: 使用正則表達式
FilterType.CUSTOM: 使用自定義規則 **/
public class MainConfig {
    @Bean("person") //給容器註冊Bean,類型為返回值類型,id默認為方法名
    public Person person(){
        return new Person("lisa",20);
    }
}