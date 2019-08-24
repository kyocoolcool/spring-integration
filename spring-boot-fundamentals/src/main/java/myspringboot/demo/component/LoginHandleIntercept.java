package myspringboot.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginHandleIntercept
 * @Description TODO
 * @Author chris
 * @Date 2019-02-09 17:52
 * @Version 1.0
 **/

public class LoginHandleIntercept implements HandlerInterceptor {
    Logger logger=LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("user");
                if(user == null){
                    request.setAttribute("msg","請先登入");
                    request.getRequestDispatcher("/login.html").forward(request,response);
                    return false;
                }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}