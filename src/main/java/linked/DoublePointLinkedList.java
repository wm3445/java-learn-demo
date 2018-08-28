package linked;

/**
 * @author wangmeng
 * <p>
 * 双端链表
 */
public class DoublePointLinkedList {


    private int size;

    private Node head;

    private Node tail;

    private class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    public DoublePointLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void addHead(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            node.next = head;
            head = node;
            size++;
        }
    }

    public void addTail(Object value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void deleteHead() {
        if (size == 0) {
            return;
        }

        if (head.next != null) {
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
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
        DoublePointLinkedList pointLinkedList = new DoublePointLinkedList();
        pointLinkedList.addHead(1);
        pointLinkedList.addHead(2);
        pointLinkedList.addHead(3);
        System.out.println(pointLinkedList.toString());
        pointLinkedList.addTail(4);
        System.out.println(pointLinkedList.toString());
        pointLinkedList.deleteHead();
        System.out.println(pointLinkedList.toString());

    }
}
