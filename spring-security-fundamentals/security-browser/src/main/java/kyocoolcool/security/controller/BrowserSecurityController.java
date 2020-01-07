package kyocoolcool.security.controller;

import kyocoolcool.security.core.properties.SecurityProperties;
import kyocoolcool.security.support.SimpleResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName BrowserSecurityController
 * @Description 當需要身份認證時，跳轉到這裡
 * @Author Chris Chen
 * @Date 2020/1/6 10:51 PM
 * @Version 1.0
 **/
@RestController
public class BrowserSecurityController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requiredAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        //請求URL是用html就會跳到登入頁面
        if (savedRequest != null) {
            final String traget = savedRequest.getRedirectUrl();
            logger.info("引發跳轉的請求是:" + traget);
            if (StringUtils.endsWithIgnoreCase(traget, ".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowserProperties().getLoginPage());
            }
        }
        //請求URL是用非html就會執行此段
        return new SimpleResponse("訪問的服務需要身份認證，請引導用戶到登入頁");
    }
}