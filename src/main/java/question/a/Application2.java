package question.a;

import java.util.Objects;

/**
 * Function：
 *
 * @author HeXin
 * @date 2019年11月22日 11:24
 * @since JDK 1.8
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */
public class Application2 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			ListNode listNode = (ListNode) o;
			return val == listNode.val &&
					Objects.equals(next, listNode.next);
		}

		@Override
		public int hashCode() {
			return Objects.hash(val, next);
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode answerHead = new ListNode(0);
		ListNode p = l1, q = l2, currentAnswer = answerHead;
		int carry = 0;
		if(l1 == null || (l1.val == 0 && l1.next==null)){
			return l2;
		}else if(l2 == null || (l2.val == 0 && l2.next==null)){
			return l1;
		}
		while (!(p == null && q == null)) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			currentAnswer.next = new ListNode(sum % 10);
			currentAnswer = currentAnswer.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		if (carry > 0) {
			currentAnswer.next = new ListNode(carry);
		}
		return answerHead.next;
	}

}
