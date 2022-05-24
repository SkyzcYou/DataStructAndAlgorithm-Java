package top.skyzc.class04;

/**
 * @Title Code03_DoubleLinkedListToDeque
 * @Description //TODO
 * @Author SkyzcYou youzhengcai@gmail.com
 * @Date 下午11:57 2022/3/26
 **/

public class Code03_DoubleLinkedListToDeque {
    public static class Node<V>{
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V v){
            value = v;
            last = null;
            next = null;
        }
    }
    public static class MyDeque<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyDeque(){
            head = null;
            tail = null;
            size = 0;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public int size(){
            return size;
        }
        public void pushHead(V value){
            // 生成新节点
            Node<V> cur = new Node<>(value);
            // 如果本来为空...
            if (head == null){
                head = cur;
                tail = cur;
            }else {
                // 操作新节点
                cur.next = head;
                // 老头的last指向新节点
                head.last = cur;
                // 移动 head
                head = cur;
            }
            size++;
        }
        public void pushTail(V value){
            Node<V> cur = new Node<>(value);
            if (tail == null){
                head = cur;
                tail = cur;
            }else {
                // 操作新节点
                cur.last = tail;
                // 老头的 next 指向新节点
                tail.next = cur;
                // 移动 tail
                tail = cur;
            }
            size++;
        }
        public V pollHead(){
            V ans = null;
            if (head == null){
                return ans;
            }
            ans = head.value;
            if (head == tail){
                head = null;
                tail = null;
            }else {
                head = head.next;
                head.last = null;
            }
            size--;
            return ans;
        }
        public V pollTail(){
            V ans = null;
            if (head == null){
                return ans;
            }
            ans = tail.value;
            if (head == tail){
                head = null;
                tail = null;
            }else {
                tail = tail.last;
                tail.next = null;
            }
            size--;
            return ans;
        }
        public V peekHead(){
            V ans = null;
            if (head != null){
                ans = head.value;
            }
            return ans;
        }
        public V peekTail(){
            V ans = null;
            if (tail != null){
                ans = tail.value;
            }
            return ans;
        }
    }
}
