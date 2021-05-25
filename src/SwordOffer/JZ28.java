package SwordOffer;

import java.util.Arrays;

/**
 * Create by hongyan on 2021/5/25
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000
 * 输入：[1,2,3,2,2,2,5,4,2]
 * 返回值：2
 *
 */
public class JZ28 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        Arrays.sort(array);
        int temp = array[0];
        int count=0;
        for(int i = 1;i<length;i++){
            if(array[i]==temp){
                count++;
            }
            if(count>= Math.floor(length/2)){
                break;
            }
            temp = array[i];
        }
        return temp;
    }

    public static void main(String[] Args){
        int [] array = {1,1,2,3,2,2,2};
        System.out.println(MoreThanHalfNum_Solution(array));

    }
}
