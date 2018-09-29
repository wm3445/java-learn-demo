package algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmeng
 * <p>
 * 使用双向链表实现lru缓存
 * <p>
 * 思路如下：
 * 1.利用HashMap缓存数据
 * 2.利用双向链表每次添加，获取的时候将节点数据移动到头结点位置
 */
public class LRUMap<K, V> {


    private final Map<K, V> cacheMap = new HashMap<>();

    /**
     * 缓存大小
     */
    private int cacheSize;
    /**
     * 节点数
     */
    private int nodeSize;

    private Node<K, V> head;

    private Node<K, V> tail;

    public LRUMap(int cacheSize) {
        nodeSize = 0;
        this.cacheSize = cacheSize;
        head = null;
        tail = null;

    }


    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        cacheMap.put(key, value);
        if (cacheMap.size() > cacheSize) {
            deleteTail();
        }
        addHead(node);
    }

    public V get(K key) {
        V v = cacheMap.get(key);
        if (null == v) {
            return null;
        }
        Node<K, V> node = findNode(key);
        moveToHead(node);
        return v;
    }

    public Node<K, V> findNode(K key) {
        int tempSize = nodeSize;
        Node<K, V> current = head;
        while (tempSize > 0) {
            if (current.getKey().equals(key)) {
                return current;
            }
            current = current.next;
            tempSize--;
        }
        return null;
    }

    public void moveToHead(Node<K, V> node) {
        if (node.prev == null) {
            return;
        }
        // 该节点为尾部节点
        if (node.next == null) {
            head.prev = node;
            node.next = head;
            head = node;
            return;
        }
        // 如果不是头结点后者尾部，先删除此结点，在将此结点移动到头结点
        node.next.prev = node.prev;
        node.prev.next = node.next;
        nodeSize--;
        // 再添加节点
        addHead(node);
    }


    public void addHead(Node<K, V> node) {
        if (nodeSize == 0) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        nodeSize++;
    }

    public void deleteTail() {
        cacheMap.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
        nodeSize--;
    }


    private class Node<K, V> {

        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        if (cacheSize == 0) {
            return "[]";
        }
        Node current = head;
        int tempSize = nodeSize;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (tempSize > 0) {
            stringBuilder.append("{ key = ").append(current.key);
            stringBuilder.append(" value = ").append(current.value).append(" }");
            current = current.next;
            tempSize--;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRUMap<String, Object> map = new LRUMap<>(5);
        map.put("1", "v1");
        map.put("2", "v2");
        map.put("3", "v3");
        map.put("4", "v4");
        map.put("5", "v5");

        System.out.println(map.toString());
        Object o = map.get("1");
        System.out.println("get value => " + o);
        System.out.println(map.toString());
    }
}
