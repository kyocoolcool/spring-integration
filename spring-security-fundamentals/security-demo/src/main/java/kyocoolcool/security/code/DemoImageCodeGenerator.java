package kyocoolcool.security.code;

import kyocoolcool.security.core.validate.code.ValidateCode;
import kyocoolcool.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ClassName DemoImageCodeGenerator
 * @Description 高級技巧，以增量的方式應對變化
 * @Author Chris Chen
 * @Date 2020/1/13 2:22 PM
 * @Version 1.0
 **/
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        System.out.println("更高級的圖形驗證碼生成代碼");
        return null;
    }
}
