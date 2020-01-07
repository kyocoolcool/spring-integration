package kyocoolcool.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyUserDetailService
 * @Description 自定義登入帳密認證實現邏輯
 * @Author Chris Chen
 * @Date 2020/1/4 12:52 PM
 * @Version 1.0
 **/
@Component
public class MyUserDetailService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.info("登入用戶名:" + userName);
        //業務邏輯:根據用戶名查找用戶訊息
        //業務邏輯:根據查找到的用戶訊息判斷用戶是否被凍結
//        User user = new User(userName, passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin")); //簡易版未判斷是否帳戶能使用
        final String password = passwordEncoder.encode("123456");
        System.out.println("password:" + password);
        User user = new User(userName, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}