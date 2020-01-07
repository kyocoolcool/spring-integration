package kyocoolcool.security.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName TimeAspect
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/10/22 10:22 AM
 * @Version 1.0
 **/
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* kyocoolcool.security.controller..*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is: " + arg);
        }
        System.out.println("timeAspect start");
        long startTime = new Date().getTime();
        Object proceed = pjp.proceed();
        System.out.println("timeAspect end");
        System.out.println("timeAspect 耗時" + (new Date().getTime() - startTime));
        System.out.println("proceed:" + proceed);
        return proceed;
    }
}