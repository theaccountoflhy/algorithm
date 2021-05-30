package SwordOffer;

import java.util.PriorityQueue;

/**
 * @className: JZ32
 * @description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author: hongyan
 * @date: 2021/5/28
 * 思路：直接字典序排序 错！！！32 <321  1<2 结果不对
 * 直接按结果排序嘛，(x+y).compareTo(y+x) 看两个正着和倒着谁大谁小
 **/
public class JZ32 {
    public static String PrintMinNumber(int [] numbers) {
        String result = "";
        if(numbers == null || numbers.length <1){
            return result;
        }
        PriorityQueue<String> temp = new PriorityQueue<String>((x,y)-> ((x+y).compareTo(y+x)) );
        for(int i : numbers){
            temp.offer(Integer.toString(i));
        }
        while(!temp.isEmpty()){
            result = result.concat(temp.poll());
        }
        return result;
    }

    public static void main(String[] Args){
        int[] a = {1,2,3};
        System.out.println(PrintMinNumber(a));

    }
}
