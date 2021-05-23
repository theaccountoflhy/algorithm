package SwordOffer;

import sun.text.normalizer.UCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Create by hongyan on 2021/5/19
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 字典序：String.compareTo的结果
 *
 * 全排列加按照字典序打印出来，所以可以先试一下全排列，然后排序，
 * 也可以直接按照字典序找全排列，较麻烦
 *
 * 需要去重 但是左神方法，牛客自测与实际运行结果不一样
 * 第二种方法：先排序得到字典序最小的序列，
 */
public class JZ27 {

/*solution1:    private static ArrayList<String> result = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        char[] temp = str.toCharArray();
        //先去重
        process1(temp,0);
        Collections.sort(result);
        return result;
    }

    public static void process1(char[] chs, int i) {
        if (i == chs.length) {
            result.add(String.valueOf(chs));
        }
        Set<Character> a = new HashSet<>();  //去重这里，
        for (int j = i; j < chs.length; j++) {
            while(!a.contains(chs[j])){
                a.add(chs[j]);
                swap(chs, i, j);
                process1(chs, i + 1);
                swap(chs,i,j);   //需要返回
            }
        }
    }*/

    private static ArrayList<String> result = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        char[] temp = str.toCharArray();
        //先去重
        process1(temp,0);
        Collections.sort(result);
        return result;
    }

    public static void process1(char[] chs, int i) {
        if (i == chs.length) {
            if(!result.contains(String.valueOf(chs))) {
                result.add(String.valueOf(chs));
            }
        }
        for (int j = i; j < chs.length; j++) {
                swap(chs, i, j);
                process1(chs, i + 1);
                swap(chs,i,j);   //需要返回
        }
    }

    public static void swap(char [] temp, int i, int j){
        char a = temp[j];
        temp[j] = temp[i];
        temp[i] = a;
    }

/*    public static ArrayList<String> Permutation(String str) {
        char[] temp = str.toCharArray();
        for(int j=temp.length ; j>= 0 ; j-- ){
            char tempchar = 
        }
    }

    public static void reverse(String str,int start,int end){


    }*/

    public static void main(String [] Args){
        String str = "aa";
        System.out.println(Permutation(str));
    }
}
