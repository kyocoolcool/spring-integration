package kyocoolcool.security.core.validate.code.sms;

/**
 * @ClassName DefaultSmsCodeSender
 * @Description TODO
 * @Author Chris Chen
 * @Date 2020/3/1 12:26 PM
 * @Version 1.0
 **/

public class DefaultSmsCodeSender implements SmsCodeSender{
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手機"+mobile+"發送短訊驗證碼"+code);
    }
}
