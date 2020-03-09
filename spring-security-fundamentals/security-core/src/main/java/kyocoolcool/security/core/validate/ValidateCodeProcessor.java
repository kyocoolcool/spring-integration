package kyocoolcool.security.core.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @description: 驗證碼處理器，封裝不同驗證碼處理邏輯
 * @param
 * @return:
 * @author: Chris Chen
 * @time: 2020/3/5 11:17 PM
 */
public interface ValidateCodeProcessor {

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);
}
