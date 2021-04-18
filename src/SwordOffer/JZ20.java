package SwordOffer;
import java.util.Stack;
/**
 * Create by hongyan on 2021/4/18
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 定义一个辅助栈，用来存最小值
 */
public class JZ20 {

    Stack<Integer> normal = new Stack<>();
    Stack<Integer> minval = new Stack<>();

    void push(int value) {
        normal.push(value);
        if (minval.empty()) {
            minval.push(value);
        }
        else {
            if (value <= minval.peek()) {
                minval.push(value);
            }
            else {
                minval.push(minval.peek());
            }
        }
    }
     void pop() {
        normal.pop();
        minval.pop();
    }
     int top() {
        return normal.peek();
    }
     int min() {
        return minval.peek();
    }
}
