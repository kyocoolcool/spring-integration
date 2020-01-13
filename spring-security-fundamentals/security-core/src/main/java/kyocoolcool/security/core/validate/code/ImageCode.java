package kyocoolcool.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @ClassName ImageCode
 * @Description 產生圖形驗證碼
 * @Author Chris Chen
 * @Date 2020/1/10 1:37 PM
 * @Version 1.0
 **/

public class ImageCode {
    private BufferedImage image;
    private String code;
    private LocalDateTime expiredTime;

    public ImageCode() {
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expiredTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public Boolean isExpired() {
        return LocalDateTime.now().isAfter(expiredTime);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }
}