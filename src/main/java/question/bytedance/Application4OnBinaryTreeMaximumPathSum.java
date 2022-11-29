package question.bytedance;

/**
 * @Description: 二叉树中的最大路径和
 * @Author 何鑫
 * @Date 2022/11/25 14:07
 */
public class Application4OnBinaryTreeMaximumPathSum {
    /**
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * <p>
     * 路径和 是路径中各节点值的总和。
     * <p>
     * 给你一个二叉树的根节点 root ，返回其 最大路径和
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxPathSum(TreeNode root) {
        tempMaxSum = Integer.MIN_VALUE;
        maxGain(root);
        return tempMaxSum;
    }

    int tempMaxSum;

    public int maxGain(TreeNode treeNode) {
        if (null == treeNode) {
            return 0;
        }

        int maxLeftNode = Math.max(maxGain(treeNode.left), 0);
        int maxRightNode = Math.max(maxGain(treeNode.right), 0);
        //left->root->right 以当前结点左右结点作为路径与已经计算过历史最大值做比较
        int nowMaxNum = treeNode.val + maxLeftNode + maxRightNode;
        tempMaxSum = Math.max(tempMaxSum, nowMaxNum);
        // 返回经过上级结点的单边最大分支给当前root的父节点计算使用
        return treeNode.val + Math.max(maxLeftNode, maxRightNode);
    }

}
