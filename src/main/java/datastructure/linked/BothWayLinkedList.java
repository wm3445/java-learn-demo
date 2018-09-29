package datastructure.linked;

/**
 * @author wangmeng
 * <p>
 * 双向链表
 */
public class BothWayLinkedList {

    private int size;

    private Node head;

    private Node tail;


    public BothWayLinkedList() {
        size = 0;
        head = null;
        tail = null;

    }


    private class Node {

        Object value;
        private Node next;
        private Node prev;

        public Node(Object value) {
            this.value = value;
        }
    }

    public void addHead(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addTail(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void deleteHead() {
        if (size == 0) {
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteTail() {
        if (size == 0) {
            return;
        }
        tail = tail.prev;
        tail.next = null;
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
        BothWayLinkedList bothWayLinkedList = new BothWayLinkedList();
        bothWayLinkedList.addHead(1);
        bothWayLinkedList.addHead(2);
        bothWayLinkedList.addHead(3);
        bothWayLinkedList.addHead(4);
        System.out.println(bothWayLinkedList.toString());
        bothWayLinkedList.addTail(5);
        bothWayLinkedList.addTail(6);
        System.out.println(bothWayLinkedList.toString());
        bothWayLinkedList.deleteHead();
        System.out.println(bothWayLinkedList.toString());
        bothWayLinkedList.deleteTail();
        System.out.println(bothWayLinkedList.toString());


    }
}
