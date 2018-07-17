package linked;

import java.util.Objects;

/**
 * @author wangmeng
 * <p>
 * 单向链表
 */
public class SingleLinkedList {


    /**
     * 链表大小
     */
    private int size;

    /**
     * 链表节点
     */
    private Node head;


    private class Node {
        /**
         * 节点数据
         */
        private Object value;
        /**
         * 下一个节点
         */
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    public void addHead(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void deleteHead() {
        head = head.next;
        size--;
    }

    public Node find(Object value) {
        if (head.value.equals(value)) {
            return head;
        }
        Node current = head;
        while (current.next != null) {
            if (current.value.equals(value)) {
                return current;
            }
        }
        return current;
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
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead(1);
        singleLinkedList.addHead(2);
        singleLinkedList.addHead(3);
        singleLinkedList.addHead(4);
        System.out.println(singleLinkedList.toString());
        singleLinkedList.deleteHead();
        System.out.println(singleLinkedList.toString());
        Node node = singleLinkedList.find(3);
        System.out.println(node.value);

    }
}
