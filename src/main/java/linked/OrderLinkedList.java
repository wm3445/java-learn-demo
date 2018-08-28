package linked;

/**
 * @author wangmeng
 * <p>
 * 有序链表
 */
public class OrderLinkedList {

    private int size;

    private Node head;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public OrderLinkedList() {
        size = 0;
        head = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        Node pre = null;
        Node current = head;
        while (current != null && value > current.value) {
            pre = current;
            current = current.next;
        }
        if (pre == null) {
            head = node;
            head.next = current;
        } else {
            node.next = current;
            pre.next = node;
        }
        size++;
    }

    public void deleteHead() {
        head = head.next;
        size--;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        Node current = head;
        int tempSize = size;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (tempSize > 0) {
            stringBuilder.append(current.value);
            if (tempSize != 1) {
                stringBuilder.append("->");
            }
            current = current.next;
            tempSize--;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        OrderLinkedList orderLinkedList = new OrderLinkedList();
        orderLinkedList.insert(7);
        orderLinkedList.insert(6);
        orderLinkedList.insert(8);
        orderLinkedList.insert(10);
        System.out.println(orderLinkedList.toString());
    }
}
