package myspringboot.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName aaa
 * @Description TODO
 * @Author chris
 * @Date 2019-01-19 14:42
 * @Version 1.0
 **/

public class aaa {
    Logger logger=LoggerFactory.getLogger(getClass());


    @Test
    public void hi(){
        hihi hihi=new hihihi();
        hihi.hi();
        ((hihihi) hihi).myhi();
    }


}