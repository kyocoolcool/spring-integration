package kyocoolcool.security.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @ClassName TimeInterceptor
 * @Description 攔截器實作
 * @Author Chris Chen
 * @Date 2019/10/21 5:16 PM
 * @Version 1.0
 **/
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        request.setAttribute("startTime", new Date().getTime());
        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod) handler).getMethod().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("TimeInterceptor耗時:" + (new Date().getTime() - startTime));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("TimeInterceptor耗時:" + (new Date().getTime() - startTime));
        System.out.println("ex is:" + ex);
    }
}