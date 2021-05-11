package SwordOffer;

import java.util.ArrayList;

/**
 * Create by hongyan on 2021/5/11
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 例如输入：{10,5,12,4,7},22  输出：[[10,5,7],[10,12]]
 * {10,5,12,4,7},15 输出：[]
 * 深度优先遍历  + 回溯！！不明白回溯
 * 其次，返回值问题困扰住我了，看了解答，觉得可以设置局部的全局变量
 */
public class JZ24 {
    private ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    private ArrayList<Integer> b = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        digui(root,target);
        return a;
    }
    public void digui(TreeNode root,int count){
        if(root==null ){
            return;
        }
        count = count -root.val;
        b.add(root.val);
        if(root.left==null&&root.right==null&&count==0){
            a.add(b);
        }
        if(root.left ==null){
            digui(root.right,count);
            digui(root.left,count);
        }
        else if(root.right ==null){
            digui(root.left,count);
            digui(root.right,count);
        }
        else if(root.left.val>=root.right.val){
            digui(root.left,count);
            digui(root.right,count);
        }
        else if(root.left.val<root.right.val){
            digui(root.right,count);
            digui(root.left,count);
        }

        b.remove(b.get(b.size()-1));

    }
}
