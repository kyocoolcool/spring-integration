package kyocoolcool.security.web.async;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName QueueListener
 * @Description 監聽器只要DeferredResultHolder有值就觸發
 * @Author Chris Chen
 * @Date 2019/12/27 5:43 PM
 * @Version 1.0
 **/

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    OrderQueue orderQueue;

    @Autowired
    DeferredResultHolder deferredResultHolder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            while (true) {
                if (StringUtils.isNotBlank(orderQueue.getCompleteOrder())) {
                    final String orderNumber = orderQueue.getCompleteOrder();
                    logger.info("返回訂單處理結果:" + orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
                    orderQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}