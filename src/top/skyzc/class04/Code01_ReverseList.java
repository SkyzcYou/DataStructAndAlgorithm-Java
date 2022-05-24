package top.skyzc.class04;

/**
 * @Title Code01_ReverseList
 * @Description // 反转链表
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午5:20 2022/3/15
 **/

public class Code01_ReverseList {
    // 单链表的一个节点
    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            value = data;
        }
    }
    // 双链表的一个节点
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            this.value = data;
        }
    }

    // 反转链表 返回反转后的头节点
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;

        while (head != null){
            next = head.next; // 记录 next
            //
            head.next = pre; // 指向 pre (前一个)

            pre = head; // pre 来到 head (当前) 的位置
            head = next; // 移动 head
        }

        /*
        while (head != null){
            next = head.next;  // 缓存下一个节点
            head.next = pre;   //

            pre = head;
            head = next;
        }
         */
        return pre;
    }
    // 反转双链表,返回反转后的头节点
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null){
            next = head.next;  // 缓存下一个节点
            // 调换当前节点的前后指针
            head.next = pre;
            head.last = next;

            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        // n1 表示头节点
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1 = reverseLinkedList(n1);
        while (n1!=null){
            System.out.print(n1.value + " ");
            n1 = n1.next;
        }
        System.out.println();
    }

}
