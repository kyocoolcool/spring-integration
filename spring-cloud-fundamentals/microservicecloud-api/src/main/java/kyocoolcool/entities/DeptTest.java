package kyocoolcool.entities;

/**
 * @ClassName DeptTest
 * @Description TODO
 * @Author chris
 * @Date 2019-02-23 08:51
 * @Version 1.0
 **/
public class DeptTest {
    public static void main(String[] args) {
        Dept dept = new Dept(2L,"hello","www.kyocoolcool");
        System.out.println(dept);
        System.out.println(true);
        Dept dept1 = new Dept();
        dept1.setDb_source("www").setDeptno(20L).setDname("haha");
        System.out.println(dept1);
    }
}