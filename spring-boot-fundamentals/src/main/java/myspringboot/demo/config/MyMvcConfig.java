package myspringboot.demo.config;

/**
 * @ClassName MyMvcConfig
 * @Description TODO
 * @Author chris
 * @Date 2019-02-09 14:44
 * @Version 1.0
 **/

import myspringboot.demo.component.LoginHandleIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * @Author chris
     * @Description 手動配置RequestMapping
     * @Date 14:52 2019-02-09
     * @Param
     * @return void
     **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addView").setViewName("success");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleIntercept()).addPathPatterns("/**").excludePathPatterns("/","/index","/login","/index.html","/login.html","/css/**","/js/**","/table","/js/vendor/**","/js/js/**");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter=new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/loginSuccess.html").setViewName("dashboard");
            }
        };

        return adapter;
    }

}