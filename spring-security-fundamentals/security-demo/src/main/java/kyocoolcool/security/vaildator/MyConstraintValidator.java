package kyocoolcool.security.vaildator;

import kyocoolcool.security.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName MyConstraintValidator
 * @Description 驗證主要邏輯
 * @Author Chris Chen
 * @Date 2019/9/30 1:48 PM
 * @Version 1.0
 **/

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
    @Autowired
    private HelloService helloService;

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("Tom");
        System.out.println("o:"+o);
        return false;
    }

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }
}