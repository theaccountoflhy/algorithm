package SwordOffer;

/**
 * @className: JZ31
 * @description: 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
 * 例如，1~13中包含1的数字有1、10、11、12、13因此共出现6次
 * @author: hongyan
 * @date: 2021/5/28
 **/
public class JZ31 {
    public  static int NumberOf1Between1AndN_Solution(int n) {
        int digit =1;
        int res = 0;
        int high =n/10;
        int cur = n%10;
        int low = 0;
        while (high != 0 || cur != 0){
            if (cur == 0){
                res += high * digit;
            }
            else if(cur == 1){
                res += high * digit + low + 1;
            }
            else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;

    }

    public static int baoli(int start,int end){
        int result =0;
        for (int i = start;i<=end;i++){
            char[] k =Integer.toString(i).toCharArray();
            for(char j:k){
                if(j == '1') result++;
            }
        }
        return result;
    }

    public static void main(String[] Args){
        System.out.println(baoli(0,1371));

        System.out.println(NumberOf1Between1AndN_Solution(1371));
    }
}
