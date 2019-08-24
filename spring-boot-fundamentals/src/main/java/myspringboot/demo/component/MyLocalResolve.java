package myspringboot.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName MyLocalResolve
 * @Description TODO
 * @Author chris
 * @Date 2019-02-09 12:11
 * @Version 1.0
 **/

public class MyLocalResolve implements LocaleResolver {
    Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale=Locale.getDefault();
        String l=request.getParameter("l");
        logger.info(l);
        if(!StringUtils.isEmpty(l)){
            logger.info("IN");
            String[] split=l.split("_");
            locale=new Locale(split[0],split[1]);
            logger.info("locale.toString()"+locale.toString());

        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}