package SwordOffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;


/**
 * Create by hongyan on 2021/5/25
 * 给定一个数组，找出其中最小的K个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 如果K>数组的长度，那么返回一个空的数组
 * 输入：[4,5,1,6,2,7,3,8],4
 * 输出：[1,2,3,4]
 *
 * 1.使用排序，然后找，O(nlogn)时间复杂度
 * 2.堆排序，此处用这种方法，练习一下大根堆的建立
 */
public class JZ29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //判定条件忘记加了

        ArrayList<Integer> result = new ArrayList<>();
        if(k<0 || k>input.length){
            return result;
        }
        PriorityQueue<Integer> temp = new PriorityQueue<Integer>((x,y)-> y-x ); //默认优先级队列是小顶堆
        for(int i =0;i< input.length;i++){
            if(temp.size()<k){
                temp.offer(input[i]);
            }
            else if(temp.peek()>input[i]){
                temp.poll();
                temp.offer(input[i]);
            }
        }

        int j=0;
        LinkedList<Integer> a = new LinkedList<>();
        while(!temp.isEmpty()){
            a.offerFirst(temp.peek());
            temp.poll();
        }
        // 大顶堆输出又是逆序的，使用LinkedList实现堆栈进行倒转
        while(!a.isEmpty()){
            result.add(a.removeFirst());
        }
        return result;
    }

}
