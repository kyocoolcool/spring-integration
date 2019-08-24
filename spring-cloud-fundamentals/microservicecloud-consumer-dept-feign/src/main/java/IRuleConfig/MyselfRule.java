package IRuleConfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyselfRule
 * @Description TODO
 * @Author chris
 * @Date 2019-02-28 11:39
 * @Version 1.0
 **/
@Configuration
public class MyselfRule  {
    @Bean
    public IRule myRule(){
//        return new RandomRule();
        return new RandomRule_ZY();
    }

}