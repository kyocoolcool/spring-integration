package kyocoolcool.security.core.validate.code.sms;

/**
 * @ClassName SmsCodeSender
 * @Description TODO
 * @Author Chris Chen
 * @Date 2020/3/1 12:25 PM
 * @Version 1.0
 **/

public interface SmsCodeSender {
    void send(String mobile, String code);
}
