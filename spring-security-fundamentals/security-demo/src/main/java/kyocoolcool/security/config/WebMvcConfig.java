package kyocoolcool.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @ClassName WebMVCConfig
 * @Description 配置靜態資源
 * @Author Chris Chen
 * @Date 2020/1/7 11:58 AM
 * @Version 1.0
 **/

@Configuration
@EnableSpringDataWebSupport
public class WebMvcConfig extends WebMvcConfigurationSupport  {

    /**
     * @description: 配置靜態資源請求及對應實際路徑
     * @param registry
     * @return: void
     * @author: Chris Chen
     * @time: 2020/1/7 3:17 PM
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * @description: 搭配請求參數使用，否則Pageable會失效
     * @param argumentResolvers
     * @return: void
     * @author: Chris Chen
     * @time: 2020/1/7 3:18 PM
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add( new PageableHandlerMethodArgumentResolver());
    }
}