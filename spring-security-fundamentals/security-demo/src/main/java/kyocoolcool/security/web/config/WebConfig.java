package kyocoolcool.security.web.config;

import kyocoolcool.security.web.filter.TimeFilter;
import kyocoolcool.security.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.ArrayList;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/10/21 5:00 PM
 * @Version 1.0
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TimeInterceptor timeInterceptor;

    /**
     * @description: 可作非同步請求的設定
     * @param registry
     * @return: void
     * @author: Chris Chen
     * @time: 2019/12/28 1:39 AM
     */
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.registerDeferredResultInterceptors()
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        TimeFilter timeFilter = new TimeFilter();
        filterFilterRegistrationBean.setFilter(timeFilter);
        ArrayList<String> urls = new ArrayList<String>();
        urls.add("/*");
        filterFilterRegistrationBean.setUrlPatterns(urls);
        return filterFilterRegistrationBean;
    }


}