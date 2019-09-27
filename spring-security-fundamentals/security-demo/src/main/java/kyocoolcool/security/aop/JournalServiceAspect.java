package kyocoolcool.security.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName JournalServiceAspect
 * @Description AOP實作
 * @Author Chris Chen
 * @Date 2019/9/27 1:52 PM
 * @Version 1.0
 **/
@Component
@Aspect
public class JournalServiceAspect {
    private final String POINT_CUT = "execution(public * kyocoolcool.security.controller..*.*(..))";

    @Pointcut(POINT_CUT)
    private void pointcut() {
        System.out.println("我沒有被呼叫");
    }


    @Before("pointcut()")
    public void doBeforeController(JoinPoint joinPoint) {
        System.out.println("AOP呼叫");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        System.out.println("methodName: " + methodName);
    }
}