package com.company.class04;

/**
 * @Title Code04_ReverseNodesInKGroup
 * @Description //TODO
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 上午1:16 2022/3/27
 **/

// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Code04_ReverseNodesInKGroup {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        //
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        // 第一组凑齐了！
        head = end;
        reverse(start, end);
        // 上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    // 从开始节点数 k 个节点,返回终止节点
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    // 给出两个节点,反转这两个之间的节点
    public static void reverse(ListNode start, ListNode end) {
        // 缓存 end 节点的下一个,留做备用 (最后 start.next 指向它)
        end = end.next;

        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;

        //当前节点不是最后(实际是 end.next ),便一直
        while (cur != end) {
            // 缓存当前的下一个
            next = cur.next;
            // 当前的下一个改为前一个
            cur.next = pre;
            // 更新 pre 为当前节点
            pre = cur;
            // 移动当前节点
            cur = next;
        }
        start.next = end;
    }

}