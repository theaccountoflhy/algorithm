package demo;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Create by hongyan on 2021/3/31
 */
public class Main {
    public static void main(String[] args){
        String to = "luohongyan";
        char[] luo = new char[to.length()];
        luo=to.toCharArray();
        Arrays.sort(luo);
        System.out.println(luo[0]);
    }
}
