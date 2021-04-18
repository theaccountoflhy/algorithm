package SwordOffer;

/**
 * Create by hongyan on 2021/4/18
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
 * 例如：输入：[4,8,6,12,16,14,10]
 * 输出：true
 * 二叉搜索树中序遍历是升序，最简单思路：使用后续遍历反序列化，然后中序遍历看看是不是升序？
 * 不对，二叉搜索树的序列化不是这样的，空节点没有标明，有问题
 * 那前驱节点后继节点这种思路呢？
 */
public class JZ23 {
    public boolean VerifySquenceOfBST(int [] sequence) {

    }
}
