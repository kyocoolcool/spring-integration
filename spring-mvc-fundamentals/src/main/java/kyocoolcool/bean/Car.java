package kyocoolcool.bean;

/**
 * @ClassName Car
 * @Description TODO
 * @Author chris
 * @Date 2019-03-19 11:09
 * @Version 1.0
 **/

public class Car {
    public Car() {
        System.out.println("car constructor..");
    }
    public void init(){
        System.out.println("car init..");
    }
    public void destroy(){
        System.out.println("car destroy..");
    }
}