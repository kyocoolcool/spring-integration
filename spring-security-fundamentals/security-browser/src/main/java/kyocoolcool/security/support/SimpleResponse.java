package kyocoolcool.security.support;

/**
 * @ClassName SimpleResponse
 * @Description TODO
 * @Author Chris Chen
 * @Date 2020/1/7 9:56 AM
 * @Version 1.0
 **/

public class SimpleResponse {

    public SimpleResponse() {
    }

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}