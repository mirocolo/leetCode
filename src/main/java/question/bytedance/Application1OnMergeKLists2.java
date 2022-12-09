package question.bytedance;

/**
 * @Description: 合并K个排序链表
 * @Author 何鑫
 * @Date 2022/11/24 20:14
 */
public class Application1OnMergeKLists2 {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoListNode(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeKListsV2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoListNode(merge(lists, l, mid), merge(lists, mid+1, r));
    }

    private ListNode mergeTwoListNode(ListNode pre, ListNode next) {
        if (null == pre || null == next) {
            return null == pre ? next : pre;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head, aPre = pre, bPre = next;
        while (aPre != null && bPre != null) {
            if (aPre.val < bPre.val) {
                tail.next = aPre;
                aPre = aPre.next;
            } else {
                tail.next = bPre;
                bPre = bPre.next;
            }
            tail = tail.next;
        }
        tail.next = (aPre != null) ? aPre : bPre;
        return head.next;
    }


}
