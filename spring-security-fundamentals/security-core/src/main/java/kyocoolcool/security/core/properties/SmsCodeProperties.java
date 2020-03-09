package kyocoolcool.security.core.properties;

/**
 * @ClassName ImageCodeProperties
 * @Description 重構參數化
 * @Author Chris Chen
 * @Date 2020/1/13 9:58 AM
 * @Version 1.0
 **/

public class SmsCodeProperties {
    private int length = 6;
    private int expireIn = 60;
    private String url;

    public SmsCodeProperties() {
    }

    public SmsCodeProperties(int length, int expireIn, String url) {
        this.length = length;
        this.expireIn = expireIn;
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
