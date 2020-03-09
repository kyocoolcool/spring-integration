package kyocoolcool.security.core.properties;


/**
 * @ClassName ValidateCodeProperties
 * @Description 認證參數封裝
 * @Author Chris Chen
 * @Date 2020/1/13 10:02 AM
 * @Version 1.0
 **/

public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }

    public SmsCodeProperties getSms() {
        return sms;
    }
}
