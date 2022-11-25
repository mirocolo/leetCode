package question.bytedance;

import java.util.Objects;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/11/24 20:15
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    public static ListNode createListNodeByIntArray(int... args) {
        ListNode res = new ListNode(0);
        ListNode head = res;

        for (int i = 0, argsLength = args.length; i < argsLength; i++) {
            res.val = args[i];
            if(i!=args.length-1){
                res.next = new ListNode(0);
                res = res.next;
            }

        }


        return head;
    }
}
