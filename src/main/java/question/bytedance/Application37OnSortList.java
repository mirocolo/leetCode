package question.bytedance;

/**
 * @Description: 链表排序
 * @Author 何鑫
 * @Date 2022/12/9 13:44
 */
public class Application37OnSortList {
    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     *
     *
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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
    class Solution {
        public ListNode sortList(ListNode head) {
            if (null == head || head.next == null) {
                return head;
            }
            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                length++;
                temp = temp.next;
            }

            ListNode dummyHead = new ListNode(-1, head);
            for (int subLength = 1; subLength < length; subLength <<= 1) {
                ListNode prev = dummyHead;
                ListNode curr = dummyHead.next;
                while (curr != null) {
                    // 1.切分
                    ListNode head1 = curr;
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }
                    // 2.合并双联表
                    prev.next = mergeList(head1, head2);
                    // 3.重新连接
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummyHead.next;
        }

        public ListNode mergeList(ListNode a, ListNode b) {
            ListNode dummyHead = new ListNode(-1);
            ListNode curr = dummyHead, temp1 = a, temp2 = b;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    curr.next = temp1;
                    temp1 = temp1.next;
                } else {
                    curr.next = temp2;
                    temp2 = temp2.next;
                }
                curr = curr.next;
            }
            curr.next = temp1 == null ? temp2 : temp1;
            return dummyHead.next;
        }
    }
}
