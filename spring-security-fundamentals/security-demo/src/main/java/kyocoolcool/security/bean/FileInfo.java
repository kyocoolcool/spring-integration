package kyocoolcool.security.bean;

/**
 * @ClassName FileInfo
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/10/22 5:33 PM
 * @Version 1.0
 **/

public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}