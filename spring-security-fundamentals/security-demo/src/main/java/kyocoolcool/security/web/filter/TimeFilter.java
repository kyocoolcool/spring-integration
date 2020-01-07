package kyocoolcool.security.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName TimeFilter
 * @Description 請求過濾器實作servlet.Filter
 * @Author Chris Chen
 * @Date 2019/10/21 11:43 AM
 * @Version 1.0
 **/

/**
 * @Component //利用Component宣告配置，若第三方lib無法加入@Component，
 * 所以透過其他配置
 * @see kyocoolcool.security.web.config.WebConfig
 */
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("timeFilter start");
        long startTime = new Date().getTime();
        chain.doFilter(servletRequest, servletResponse);
        System.out.println("耗時:" + (new Date().getTime() - startTime));
        System.out.println("timeFilter finish");
    }

    @Override
    public void destroy() {
        System.out.println("timeFilter destroy");
    }
}