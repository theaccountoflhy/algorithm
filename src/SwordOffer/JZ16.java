package SwordOffer;

/**
 * Create by hongyan on 2021/4/13
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 输入：{1,3,5},{2,4,6}   输出：{1,2,3,4,5,6}
 * 直接两边同时遍历，参考归并排序
 * 20210413，扣一下边界条件
 */
public class JZ16 {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null ){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode p = new ListNode(-1);
        ListNode q = p;

        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){
                q.next = list1;
                list1= list1.next;
            }
            else{
                q.next = list2;
                list2 = list2.next;
            }
            q =q.next;

        }

        //有一个为空之后.接上后续没弄完的
        q.next = list1 != null? list1:list2;
        return p.next;
    }


    public static void main(String[] Args){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(6);
        b1.next = b2;
        b2.next = b3;
        b3.next = null;

        System.out.println(Merge(a1,b1).toString());

    }
}
