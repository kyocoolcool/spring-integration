package kyocoolcool.security.core.validate.code;

import kyocoolcool.security.core.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName ValidateCodeFilter
 * @Description 只會被調用一次，此filter進行過濾驗證再轉交原來的UsernamePasswordAuthenticationFilter驗證
 * @Author Chris Chen
 * @Date 2020/1/10 2:40 PM
 * @Version 1.0
 **/

public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {
    private AuthenticationFailureHandler authenticationFailureHandler;
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    private Set<String> urls=new HashSet<>();
    private SecurityProperties securityProperties;
    private AntPathMatcher pathMatcher=new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(), ",");
        Arrays.asList(configUrls).stream().forEach(x->urls.add(x));
        urls.add("/authentication/form");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            AtomicBoolean action = new AtomicBoolean(false);
//        if (StringUtils.equals("/authentication/form", request.getRequestURI()) && StringUtils.equalsIgnoreCase(request.getMethod(),"post")) {
        urls.forEach(url-> {
            if (pathMatcher.match(url, request.getRequestURI())) {
                action.set(true);
            }
        });
        if (action.get()) {
            try {
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                logger.info("捕捉到ValidateCodeException");
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
            filterChain.doFilter(request, response);
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        ImageCode codeInSession =(ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);
        String codeInRequest=ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("驗證碼的值不能為空");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("驗證碼不存在");
        }

        if (codeInSession.isExpired()) {
            sessionStrategy.removeAttribute(request,ValidateCodeController.SESSION_KEY);
            throw new ValidateCodeException("驗證碼已過期");
        }
        if (!StringUtils.equals(codeInSession.getCode(),codeInRequest)) {
            throw new ValidateCodeException("驗證碼不匹配");
        }
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public SessionStrategy getSessionStrategy() {
        return sessionStrategy;
    }

    public void setSessionStrategy(SessionStrategy sessionStrategy) {
        this.sessionStrategy = sessionStrategy;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}