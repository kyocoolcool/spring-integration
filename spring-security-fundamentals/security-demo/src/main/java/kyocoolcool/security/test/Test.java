package kyocoolcool.security.test;

import java.io.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Chris Chen
 * @Date 2019/9/24 3:46 PM
 * @Version 1.0
 **/

public class Test {
    public static void main(String[] args) {
        String  thisLine = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader("/opt/aaa"));
            while ((thisLine = br.readLine()) != null) {
                System.out.println(thisLine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}