package SwordOffer;

import java.util.*;

/**
 * Create by hongyan on 2021/5/17
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 思路： 二叉搜索树的中序遍历升序。
 */
public class JZ26 {

    private static Queue<TreeNode> a = new LinkedList<>();

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        middleOrder(pRootOfTree);
        TreeNode result = a.poll();
        TreeNode temp = result;
        temp .left =null;
        TreeNode temp2;

        while(!a.isEmpty()){
            temp2 = a.poll();
            temp.right =temp2;
            temp2.left = temp;

            temp = temp2;
        }
        temp.right  =null;

        return result;
    }

    public static void middleOrder(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return;
        }
        middleOrder(pRootOfTree.left);
        a.add(pRootOfTree);
        middleOrder(pRootOfTree.right);
    }

    public static void main(String[] Args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);


        TreeNode result = Convert(root);
        while(result != null){
            System.out.println(result.val);
            result = result.right;
        }

    }
}
