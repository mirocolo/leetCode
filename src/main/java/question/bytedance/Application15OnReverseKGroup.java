package question.bytedance;

/**
 * @Description: K个一组翻转链表
 * @Author 何鑫
 * @Date 2022/12/5 12:45
 */
public class Application15OnReverseKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     *  
     * <p>
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     *  
     * <p>
     * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    static class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy;
            ListNode end = dummy;

            while (end.next != null) {
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }

                ListNode start = pre.next;
                ListNode next = end.next;

                end.next = null;

                pre.next = reverse(start);

                start.next = next;
                pre = start;
                end = pre;

            }


            return dummy.next;
        }


        public ListNode reverse(ListNode start) {
            ListNode pre = null;
            ListNode curr = start;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = ListNode.createListNodeByIntArray(1, 2, 3, 4, 5, 6, 7);
        ListNode reverse = solution.reverseKGroup(listNode, 3);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
