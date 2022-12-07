package question.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 锯齿形层序遍历
 * @Author 何鑫
 * @Date 2022/12/6 14:11
 */
public class Application18OnZigzagLevelOrder {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[20,9],[15,7]]
     * 示例 2：
     * <p>
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：[]
     *  
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean leftToRight = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> ansNodeList = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (leftToRight) {
                        ansNodeList.add(node.val);
                    } else {
                        ansNodeList.add(0, node.val);
                    }
                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                }
                leftToRight = !leftToRight;
                res.add(ansNodeList);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Application18OnZigzagLevelOrder.Solution solution=new Solution();
        TreeNode node = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        List<List<Integer>> lists = solution.zigzagLevelOrder(node);
        lists.forEach(System.out::println);

    }
}
