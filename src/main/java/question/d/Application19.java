package question.d;

/**
 * @Description: 删除链表的倒数第 N 个结点
 * @Author 何鑫
 * @Date 2022/7/14 17:12
 */
public class Application19 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *  
     * <p>
     * 提示：
     * <p>
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode slow = new ListNode(0,head);
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            if(fast == null){
                return head.next;
            }
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
