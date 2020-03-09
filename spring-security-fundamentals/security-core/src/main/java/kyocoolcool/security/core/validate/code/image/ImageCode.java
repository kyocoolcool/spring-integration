package kyocoolcool.security.core.validate.code.image;

import kyocoolcool.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;

/**
 * @ClassName ImageCode
 * @Description 產生圖形驗證碼
 * @Author Chris Chen
 * @Date 2020/1/10 1:37 PM
 * @Version 1.0
 **/

public class ImageCode extends ValidateCode {
    private BufferedImage image;

    public ImageCode() {
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code,expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
