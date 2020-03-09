package kyocoolcool.security.core.properties;

/**
 * @ClassName ImageCodeProperties
 * @Description 重構參數化
 * @Author Chris Chen
 * @Date 2020/1/13 9:58 AM
 * @Version 1.0
 **/

public class ImageCodeProperties extends SmsCodeProperties{

    public ImageCodeProperties() {
        setLength(4);
    }

    private int width = 74;
    private int height = 23;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
