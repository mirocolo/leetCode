package question.d;

import junit.framework.LeetCodeTestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/7/14 17:34
 */
public class Application19Test extends LeetCodeTestCase<Application19> {

    @Test
    public void removeNthFromEndV2() {
        ListNode listNode = new ListNode(1,null);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = instance.removeNthFromEndV2(listNode, 2);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,null);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        Application19 application19 = new Application19();
        ListNode listNode1 = application19.removeNthFromEndV2(listNode, 2);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}