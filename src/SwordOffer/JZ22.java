package SwordOffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**从上往下打印二叉树
 * Create by hongyan on 2021/4/18
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 输入：{5,4,#,3,#,2,#,1}
 * 输出：[5,4,3,2,1]
 */
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> tool = new LinkedList<>();
        if(root == null){
            return result;
        }
        tool.add(root);

        while(!tool.isEmpty()){
            //先弹出
            root = tool.poll();
            if(root.left != null){
                tool.add(root.left);
            }
            if(root.right != null){
                tool.add(root.right);
            }
            result.add(root.val);
        }
        return result;
    }
}
