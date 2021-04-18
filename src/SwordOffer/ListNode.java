package SwordOffer;

/**
 * Create by hongyan on 2021/4/13
 */
public class ListNode {

        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }

        public String toString(){
            return  ""+this.val+this.next.val+this.next.next.val;
        }
}
