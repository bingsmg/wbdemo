package live.cloverescape.lc.cachealgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author weibb
 * @date 2023-11-08
 */
public class LRUCache {

    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int size;
    int capacity;

    static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (Objects.isNull(node)) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (Objects.nonNull(node)) {
            node.value = value;
            moveToHead(node);
        }
        if (size == capacity) {
            delNode(tail.prev);
            cache.remove(tail.key);
            size--;
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
        ++size;
    }

    public void moveToHead(Node node) {
        delNode(node);
        addToHead(node);
    }

    public void delNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
}
