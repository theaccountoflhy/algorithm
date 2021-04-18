package SwordOffer;

/**
 * Create by hongyan on 2021/4/13
 * 输入一个链表，反转链表后，输出新链表的表头。
 * {1,2,3}
 * {3,2,1}
 * 堆栈、递归、单链表求解
 */
public class JZ15 {

    public ListNode ReverseList(ListNode head) {
        if(head ==null || head.next == null  ){ //若输入为{}，输出为空指针异常？ 优先级高的判断条件要写前面
            return head;
        }


        ListNode reverse = ReverseList(head.next);
        head.next.next = head;
        head.next = null; //尾节点都为空
        return reverse;
    }
}
