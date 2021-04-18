package SwordOffer;

/**
 * Create by hongyan on 2021/4/18
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 输入{8,8,#,9,#,2,#,5},{8,9,#,2}
 * 返回true
 * 两个递归，第一个递归遍历找到所有相同的头结点，第二个递归相同头结点往下遍历
 */
public class JZ17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 ==null){
            return false;
        }

        if(root1.val == root2.val){
            if(juge(root1,root2)){
                return true;
            }
        }

        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);

    }
    public boolean juge(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return juge(root1.left,root2.left)&&juge(root1.right,root2.right);
        }
        return false;
    }

    public static void TreeWalk(TreeNode root){
        if(root==null){
            return ;
        }
        TreeWalk(root.left);
        TreeWalk(root.right);
    }

    public static void main(String[] Args){


    }
}
