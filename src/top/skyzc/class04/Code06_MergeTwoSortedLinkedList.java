package top.skyzc.class04;

// 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
public class Code06_MergeTwoSortedLinkedList {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		// 通过判断两个链表的前两个元素,找到总头
		ListNode head = head1.val <= head2.val ? head1 : head2;
		// 小头的下一个是 cur1
		ListNode cur1 = head.next;
		/// 大头就是 cur2
		ListNode cur2 = head == head1 ? head2 : head1;

		// 缓存 pre
		ListNode pre = head;
		while (cur1 != null && cur2 != null) {
			//  谁小给叫给 pre.next
			if (cur1.val <= cur2.val) {
				pre.next = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				cur2 = cur2.next;
			}
			pre = pre.next;
		}
		pre.next = cur1 != null ? cur1 : cur2;
		return head;
	}

}
