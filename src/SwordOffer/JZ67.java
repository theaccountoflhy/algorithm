package SwordOffer;

/**
 * Create by hongyan on 2021/4/3
 *给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入int n 2=<n<=60，输出int
 * 从暴力递归到动态规划的过程..
 * 暴力递归算法复杂度过大
 */
public class JZ67 {
    public static int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }

        return cutViolence(target);
    }

    //切割成1-n段,暴力递归
    public static int cutViolence(int n){
        //递归basecase
        if(n == 2){
            return n;
        }
        if(n == 3){
            return n;
        }

        int res = 0;
        for(int i =1; i < n ; ++i){
            res = Math.max(res,i*cutViolence(n-i));
        }
        return res;

    }



    public static void main(String[] Args){
        int target = 8;
        int result = cutRope(target);
        System.out.println(result);
    }
}
