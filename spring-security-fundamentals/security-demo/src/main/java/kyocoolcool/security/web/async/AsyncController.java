package kyocoolcool.security.web.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @ClassName AsyncController
 * @Description 異步處理REST服務，增加效能
 * @Author Chris Chen
 * @Date 2019/12/27 4:26 PM
 * @Version 1.0
 **/

@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderQueue orderQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @RequestMapping("/order")
    public DeferredResult<String> order() throws Exception {
        logger.info("主線程開始");
        final String orderNumber = RandomStringUtils.randomNumeric(8);
        orderQueue.setPlaceOrder(orderNumber);
        final DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
//        final Callable<String> result = () -> {
//            logger.info("副線程開始");
//            Thread.sleep(1000);
//            logger.info("副線程結束");
//            return "success";
//        };
        logger.info("主線程返回");
        return result;
    }
}