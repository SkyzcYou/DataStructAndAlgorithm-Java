package com.company.class06;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Title Code01_MergeKSortedLists
 * @Description //TODO
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午6:11 2022/3/28
 **/

public class Code01_MergeKSortedLists {
    // 单链表节点
    public static class ListNode{
        public int val;
        public ListNode next;
    }
    public static class ListNodeComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null){
            return null;
        }
        // 优先级队列 小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        // 将所有头节点扔进小根堆
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()){
            return null;
        }
        // 弹出一个 (最小的) 作为整体的 head
        ListNode head = heap.poll();
        ListNode pre = head; //
        if (pre.next != null){
            heap.add(pre.next);
        }
        while (!heap.isEmpty()){
            ListNode cur = heap.poll(); // 弹出
            pre.next = cur; // 接上前一个
            pre = cur;
            if (cur.next != null){ // 如果还有节点
                heap.add(cur.next); // 则加入 heap
            }
        }
        return head;
    }
}
