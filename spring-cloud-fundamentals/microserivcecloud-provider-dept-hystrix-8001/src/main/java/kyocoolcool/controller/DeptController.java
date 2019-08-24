package kyocoolcool.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kyocoolcool.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import kyocoolcool.service.DeptService;

import java.util.List;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author chris
 * @Date 2019-02-23 14:23
 * @Version 1.0
 **/
@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        if(service.get(id)==null)
            throw new RuntimeException("該ID不存在" + id + "沒有對應的訊息");
        return service.get(id);
    }

    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("該ID不存在" + id + "沒有對應的訊息--@HystrixCommand")
                .setDb_source("no this data in mysql");
    }
}