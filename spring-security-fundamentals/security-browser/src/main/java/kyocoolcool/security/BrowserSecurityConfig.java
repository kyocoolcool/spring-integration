package kyocoolcool.security;

import kyocoolcool.security.authentication.MyAuthenticationFailureHandler;
import kyocoolcool.security.authentication.MyAuthenticationSuccessHandler;
import kyocoolcool.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName BrowserSecurityConfig
 * @Description SpringSecurity配置類
 * @Author Chris Chen
 * @Date 2020/1/3 4:59 PM
 * @Version 1.0
 **/

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @description: 自訂義登入請求、處理驗證、授權
     * @param http
     * @return: void
     * @author: Chris Chen
     * @time: 2020/1/7 3:14 PM
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //httpBasic()登入方式
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrowserProperties().getLoginPage(),"/error").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    /**
     * @description: 搭配Spring Security須額外設定 靜態資源不需要認證授權
     * @param web
     * @return: void
     * @author: Chris Chen
     * @time: 2020/1/7 3:16 PM
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    //配置全局配置
    private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //設置UserDetailsService以及密碼規則
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}