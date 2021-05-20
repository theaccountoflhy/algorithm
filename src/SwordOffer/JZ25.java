package SwordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by hongyan on 2021/5/13
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）。
 *
 * 思路：使用HashMap Key-Value 对,为了能够快速找到random指向的那个对象，编程不熟练啊
 */
public class JZ25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> a= new HashMap<>();

        RandomListNode temp = pHead;
        while(temp != null){
            RandomListNode newNode = new RandomListNode(temp.next.label);
            a.put(temp,newNode);
            temp = temp.next;
        }

        RandomListNode temp2 = pHead;

        while(temp2.next != null){
            a.get(temp2).next = (temp2.next==null)?null:a.get(temp2.next) ;
            a.get(temp2).random = (temp2.random==null)?null:a.get(temp2.random) ;
            temp2 = temp2.next;
        }

        a.get(temp2).next = null;
        a.get(temp2).random = (temp2.random==null)?null:a.get(temp2.random) ;
        return a.get(pHead);
    }
}
