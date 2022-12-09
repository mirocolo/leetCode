package question.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 199. 二叉树的右视图
 * @Author 何鑫
 * @Date 2022/12/8 9:51
 */
public class Application28OnRightSideView {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if(poll == null){
                        continue;
                    }
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                    if (i == size - 1) {
                        ans.add(poll.val);
                    }
                }
            }
            return ans;
        }
    }

    class Solution2 {

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root, 0, ans);
            return ans;
        }

        private void dfs(TreeNode node, int depth, List<Integer> ans) {
            if (node == null) {
                return;
            }
            if(depth == ans.size()){
                ans.add(node.val);
            }
            dfs(node.right,depth+1,ans);
            dfs(node.left,depth+1,ans);
        }
    }
}
