package SwordOffer;

import java.util.PriorityQueue;

/**
 * @className: JZ30
 * @description: 输入一个整型数组，数组里有正数也有负数。
 *                 数组中的一个或连续多个整数组成一个子数组。
 *                  求所有子数组的和的最大值。
 *
 *                  要求时间复杂度为 O(n)!!!!!!!!
 *
 * [1,-2,3,10,-4,7,2,-5]
 * 18
 *输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 * @author: hongyan
 * @date: 2021/5/27
 **/
public class JZ30 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array ==null||array.length <1){
            return Integer.MIN_VALUE;
        }
        return digui(array,0,array.length-1);
    }

    public static int digui(int[] array,int start,int end){
        if(start>end){
            return Integer.MIN_VALUE;
        }
        int temp =0;
        PriorityQueue<Integer> a = new PriorityQueue<>((x,y) -> (y-x));
        for(int i = start;i <= end;i++){
            temp = temp+array[i];
            a.offer(Math.max(temp,digui(array,start+1,end)));
        }
        return a.peek();
    }

    public static void main(String[] Args){
        int[] a = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(a));

    }
}
