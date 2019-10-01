package kyocoolcool.security.exception;

/**
 * @ClassName UserNotExistException
 * @Description 自定義異常
 * @Author Chris Chen
 * @Date 2019/10/1 9:48 AM
 * @Version 1.0
 **/

public class UserNotExistException extends RuntimeException {
    private String id;
    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}