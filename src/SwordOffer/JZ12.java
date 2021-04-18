package SwordOffer;

/**
 * Create by hongyan on 2021/4/8
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * 例：输入 2,3  输出：8.0000
 * 注意int可以为负数
 */
public class JZ12 {
    public static double Power(double base, int exponent) {
        if(base == 0){
            return 0;
        }
        if(exponent == 0)
            return 1;

        if(exponent <0){
            return 1.0/base*Power(base,exponent + 1);
        }
            return base * Power(base, exponent - 1);


    }
    public static void main(String[] Args){
        double base =0;
        int exponent = -2;
        System.out.println(Power(base,exponent));
    }
}
