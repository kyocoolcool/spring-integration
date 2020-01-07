package kyocoolcool.security.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DeferredResult
 * @Description 用來做線程溝通
 * @Author Chris Chen
 * @Date 2019/12/27 5:14 PM
 * @Version 1.0
 **/

@Component
public class DeferredResultHolder {
    Map<String, DeferredResult<String>> map = new HashMap<String, DeferredResult<String>>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}