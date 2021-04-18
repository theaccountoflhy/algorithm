package SwordOffer;

/**
 * Create by hongyan on 2021/4/8
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 输入：【1,2,3,4】 【1,3,2,4】
 * 类似稳定的排序，原地算法，使用可以设计成稳定的插入排序思想
 */
public class JZ13 {
    public static int[] reOrderArray (int[] array) {

        // 记录奇数位置
        int odd =0;
        if(array.length == 1){
            return array;
        }

        for(int i =0; i<array.length; i++){

            for(int j =i; j>0 && array[j-1]%2==0 && array[j]%2==1;j--){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
            }
        }
        return array;
    }

    public  static  void main(String[] Args){
        int[] a = {1,2,3,4};
        System.out.println(reOrderArray(a)[1]);


    }

}
