package kyocoolcool.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName ValidateCodeException
 * @Description TODO
 * @Author Chris Chen
 * @Date 2020/1/10 3:06 PM
 * @Version 1.0
 **/

public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}