package demo;

/**
 *  暴力尝试到动态规划的问题
 *
 * 汉诺塔问题 三个杆，左中右，左边有有N个上小下大的块
 * 要求：将N个块从左杆搬移到右边，*不能大压小* 打印所有搬移过程；
 *
 * 思路：先把杆子分为 from to 和help杆
 * 分析最简单的 N=2问题，和N=3问题，
 * 于是将N问题分为1-(N-1)和N的问题
 */

public class Hanoi {
    public static void process(int N,String from,String help,String to){
        if(N==1){
            System.out.println("move"+1+" from"+from+" to"+to);
            return;
        }
        process(N-1,from,to,help);
        System.out.println("move"+N+" from"+from+" to"+to);
        process(N-1,help,from,to);
    }

    public static void main(String[] Args){
        process(3,"左","中","右");
    }
}
