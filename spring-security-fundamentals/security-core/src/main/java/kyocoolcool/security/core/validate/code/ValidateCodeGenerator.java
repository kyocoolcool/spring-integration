package kyocoolcool.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName ValidateCodeGenerator
 * @Description 開放可修改API
 * @Author Chris Chen
 * @Date 2020/1/13 1:53 PM
 * @Version 1.0
 **/

public interface ValidateCodeGenerator {
     ImageCode createImageCode(ServletWebRequest request) ;
}