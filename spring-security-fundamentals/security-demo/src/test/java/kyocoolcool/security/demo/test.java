package kyocoolcool.security.demo;

import org.junit.Test;

/**
 * @ClassName test
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/10/4 11:44 AM
 * @Version 1.0
 **/

public class test {
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        test.name = name;
    }

    @Test
    public void h() {
        test2 test2 = new test2();
        test2.hh();
        System.out.println(name);
    }
}