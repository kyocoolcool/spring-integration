package kyocoolcool.security;

import kyocoolcool.security.authentication.MyAuthenticationFailureHandler;
import kyocoolcool.security.authentication.MyAuthenticationSuccessHandler;
import kyocoolcool.security.core.properties.SecurityProperties;
import kyocoolcool.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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

//    @Autowired
//    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        final JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
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
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        //httpBasic()登入方式
            http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowserProperties().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrowserProperties().getLoginPage(),"/error","/code/image").permitAll()
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