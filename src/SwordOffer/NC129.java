package SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by hongyan on 2021/5/23
 *请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 * 输入：[1,2,4,5,3],[4,2,5,1,3] 输出：[1,3,5]
 * 备注：二叉树每个节点的值在区间[1,10000]内，且保证每个节点的值互不相同。
 *
 * 右视图：每层最右边的数
 *
 * 简单思路：先由先序中序来构建二叉树，然后层序遍历，即可找到
 * 好像也没什么简便方法,c
 * 层序遍历后怎么得到答案呢？
 * 解决办法：在层序遍历过程中，记录每一次的size，保证每一次添加把一层的添加完；
 * 注：queue加元素使用offer，不使用add，add在容量满的时候回抛IllegalStateException异常，offer只会返回false。
 */
public class NC129 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public static int[] solve (int[] xianxu, int[] zhongxu) {

        if(xianxu==null || xianxu.length ==0){
            return null;
        }
        TreeNode root = rebulid(xianxu,0,xianxu.length-1,zhongxu,0,zhongxu.length-1);
        int[] result = bfs(root);
        return result;
    }

    public static int[] bfs(TreeNode root){
        if(root == null){
            return null;
        }
        ArrayList<Integer> a = new ArrayList<>();
        Queue<TreeNode> bianLi = new LinkedList<>();

        bianLi.offer(root);
        while(!bianLi.isEmpty()) {
            for(int size = bianLi.size();size>0;size--) {
                root = bianLi.poll();
                if (root.left != null) {
                    bianLi.offer(root.left);
                }
                if (root.right != null) {
                    bianLi.offer(root.right);
                }
            }
            a.add(root.val);
        }
        return a.stream().mapToInt(Integer::valueOf).toArray();

    }

    public static TreeNode rebulid(int[] xianxu,int start1,int end1,int[] zhongxu,int start2,int end2){
        if( start1 > end1){
            return null;
        }
        TreeNode root = new TreeNode(xianxu[start1]);
        int temp =0;
        for(int i = start2;i<=end2;i++){
            if(zhongxu[i]==xianxu[start1]){
                temp=i;
                break;
            }
        }
        root.left = rebulid(xianxu,start1+1,temp-start2+start1,zhongxu,start2,temp-1);
        root.right = rebulid(xianxu,temp-start2+start1+1,end1,zhongxu,temp+1,end2);
        return root;
    }

    public static void main(String[] Args){
        int[] xianxu = {1,2,4,5,3};
        int[] zhongxu = {4,2,5,1,3};
        int[] a =solve(xianxu,zhongxu);
        for (int i:a
             ) {
            System.out.println(i);
        }
    }
}
