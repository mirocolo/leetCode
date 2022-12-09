package question.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 二叉树的层序遍历
 * @Author 何鑫
 * @Date 2022/12/8 13:29
 */
public class Application29OnLevelOrder {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 示例 2：
     *
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     *
     * 输入：root = []
     * 输出：[]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue =  new LinkedList<>();
            queue.add(root);
            List<List<Integer>> ans = new ArrayList<>();
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> oneAns = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if(null==poll){
                        continue;
                    }
                    if(null!=poll.left){
                        queue.offer(poll.left);
                    }
                    if(null!=poll.right){
                        queue.offer(poll.right);
                    }
                    oneAns.add(poll.val);
                    if(i == size -1 ){
                        ans.add(oneAns);
                    }
                }
            }
            return ans;
        }
    }
}
