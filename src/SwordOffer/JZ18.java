package SwordOffer;

/**
 * Create by hongyan on 2021/4/18
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入：{8,6,10,5,7,9,11}
 * 输出：{8,10,6,11,9,7,5}
 * 将二叉树以中轴线旋转
 * 想法：先想的是中序遍历上的操作，后来想的是，每一级往下左变右就好了，在遍历的过程中换一下就好了
 */
public class JZ18 {
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null){
            return null;
        }
        TreeNode temp = pRoot.right;
        pRoot .right = Mirror(pRoot.left);
        pRoot .left = Mirror(temp);

        return pRoot;
    }
}
