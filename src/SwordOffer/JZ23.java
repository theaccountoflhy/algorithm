package SwordOffer;

import java.util.Stack;

/**
 * Create by hongyan on 2021/4/18
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
 * 例如：输入：[4,8,6,12,16,14,10]
 * 输出：true
 * 二叉搜索树中序遍历是升序，最开始思路：使用后续遍历反序列化，然后中序遍历看看是不是升序？
 * 不对，二叉搜索树的序列化不是这样的，空节点没有标明，有问题
 * 那前驱节点后继节点这种思路呢？不行
 *
 * 思路：[|4,8,6|,|12| | |,|16,14,10|] 对矩阵分块，最大约束法？假设这是个二叉搜索树
 * 那么，最后一块递减的为该树的最右边的枝丫，剩余从由往左按照16-14,14-10 ,<10 划分三个区域（可为空）为右侧三个节点的左子树（不能完全划分数组，那就不是二叉搜索树）
 * 对每一个子树进行相似判断划分，划分的终点为 该区域为null，一旦不能完全划分，则不是二叉搜索树.
 *
 *上述思路难写，换个思路，直接递归，按照最后一个值即根节点划分数组（左右子树）进行递归，
 * 在子函数按从后往前顺序找到划分节点后，在判断划分节点以前是不是全小于根几点
 */
public class JZ23 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length <1){
            return false;}
        return isBST(sequence,0 ,sequence.length-1);
    }
    public static boolean isBST(int [] sequence, int start,int end){
        if(start >= end){
            return true;
        }
        int split = start;
        for(int i =end ;i>= start;i--){
            if(sequence[i] < sequence[end]){
                split = i+1;
                break;
            }
        }
        for(int j =split-1 ; j>= start ; j--){
            if(sequence[j] > sequence[end]){
                return false;
            }
        }
        return (isBST(sequence, start,split-1) && isBST(sequence,split,end-1));


    }

    }


