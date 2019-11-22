package question.a;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Function：
 *
 * @author HeXin
 * @date 2019年11月22日 14:15
 * @since JDK 1.8
 */
public class Application2Test {

	private Application2 application2 = new Application2();
	private Application2.ListNode l1;
	private Application2.ListNode l2;
	private Application2.ListNode expected;

	@Before
	public void setUp() throws Exception {
		l1 = new Application2.ListNode(2);
		l1.next = new Application2.ListNode(4);
		l1.next.next = new Application2.ListNode(3);
		l2 = new Application2.ListNode(5);
		l2.next = new Application2.ListNode(6);
		l2.next.next = new Application2.ListNode(4);
		expected = new Application2.ListNode(7);
		expected.next = new Application2.ListNode(0);
		expected.next.next = new Application2.ListNode(8);
	}

	@Test
	public void addTwoNumbers() {
		Application2.ListNode result = application2.addTwoNumbers(l1, l2);
		Assert.assertEquals(result,expected);
	}
}