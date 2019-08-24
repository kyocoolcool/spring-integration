package kyocoolcool.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName LinuxConditional
 * @Description TODO
 * @Author chris
 * @Date 2019-03-18 17:03
 * @Version 1.0
 **/

public class LinuxConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if(property.contains("Linux"))
            return true;
        return false;
    }
}