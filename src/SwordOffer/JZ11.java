package SwordOffer;

/**
 * Create by hongyan on 2021/4/6
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 例如：输入10，返回2
 */
public class JZ11 {
    //2取模，负数用例不对，补码传输，这样求的是原码的1
    public static int NumberOf1_1(int n) {
        int res = 0;
        int i;
        i =n;
        while(i !=0){
            if( (i % 2 ==1)||(i % 2 ==-1)){
                res ++;
            }
            i = i/2;   //
        }
        return res;
    }

    //按位检测
    public static int NumberOf1_2(int n) {
        int res1 = 0;
        int m = 1;
        int k =0;
        while(k <= 32){

            if( (n&m) != 0){
                res1 ++;
            }
            m = m<<1;   //
            k++;
        }
        return res1;
    }

    public static void main(String[] Args){
        int i = -3;
        System.out.println(NumberOf1_2(i));
    }
}
