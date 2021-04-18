package SwordOffer;
import java.util.*;
/**
 * Create by hongyan on 2021/4/13
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空
 * 输入 {1,2,3,4,5},1   输出 {5}
 * 思路 1.双指针，第一个指针k步，第二个指针开始
 *      2. 使用堆栈
 *      3. 递归递归
 *      使用堆栈
 */

public class JZ14 {


    public ListNode FindKthToTail (ListNode pHead, int k) {
        Stack<ListNode> a =new Stack<>();
        int i =1;
        while(pHead != null){
            a.push(pHead);
            pHead = pHead.next;
            i++;
        }

        if(k==0 || i<k){
            return null;
        }

        ListNode p= a.pop();
        while(--k >0){
            p = a.pop();
        }

        return p;
    }

}
