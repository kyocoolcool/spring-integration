package kyocoolcool.service;

import feign.hystrix.FallbackFactory;
import kyocoolcool.entities.Dept;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName DeptClientServiceFallbackFactory
 * @Description TODO
 * @Author chris
 * @Date 2019-03-01 20:14
 * @Version 1.0
 **/
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("ID: "+id+"沒有對應的訊息,Consumer客戶端提供降級訊息,此刻服務Provider暫停使用")
                        .setDb_source("no this data in Mysql");
            }

            public List<Dept> list() {
                return null;
            }

            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}