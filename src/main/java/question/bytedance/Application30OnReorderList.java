package question.bytedance;

/**
 * @Description: 143. 重排链表
 * @Author 何鑫
 * @Date 2022/12/8 13:53
 */
public class Application30OnReorderList {

    class Solution {
        /**
         * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
         *
         * L0 → L1 → … → Ln - 1 → Ln
         * 请将其重新排列后变为：
         *
         * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
         * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
         *
         *  
         *
         * 示例 1：
         *
         *
         *
         * 输入：head = [1,2,3,4]
         * 输出：[1,4,2,3]
         * 示例 2：
         *
         *
         *
         * 输入：head = [1,2,3,4,5]
         * 输出：[1,5,2,4,3]
         *  
         *
         * 提示：
         *
         * 链表的长度范围为 [1, 5 * 104]
         * 1 <= node.val <= 1000
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode.cn/problems/reorder-list
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         * @param head
         */
        public void reorderList(ListNode head) {

            if (null == head) {
                return;
            }
            ListNode middleNode = middleNode(head);
            ListNode listA = head;
            ListNode listB = middleNode.next;
            // 截断
            middleNode.next = null;

            listB = reverseList(listB);
            mergeList(listA, listB);
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverseList(ListNode listB) {
            ListNode pre = null;
            ListNode curr = listB;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }

        private void mergeList(ListNode listA, ListNode listB) {
            ListNode tmpA;
            ListNode tmpB;
            while (listA != null && listB != null) {
                tmpA = listA.next;
                tmpB = listB.next;
                listA.next = listB;
                listA = tmpA;

                listB.next = listA;
                listB = tmpB;
            }
        }


    }
}
