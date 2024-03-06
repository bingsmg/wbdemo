package live.cloverescape.lc.cachealgo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 * @date 2023-11-08
 */
class LFUCache {

    int minFreq;
    int capacity;
    Map<Integer, Node> keyMap;
    Map<Integer, DLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        int value = node.value;
        int freq = node.freq;
        freqMap.get(freq).delNode(node);
        if (freqMap.get(freq).size == 0) {
            freqMap.remove(freq);
            if (minFreq == freq) {
                minFreq += 1;
            }
        }
        DLinkedList list = freqMap.getOrDefault(freq + 1, new DLinkedList());
        return -1;
    }

    public void put(int key, int value) {

    }

    static class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DLinkedList {
        int size;
        Node head;
        Node tail;

        DLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        public void delNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        public Node getHead() {
            return head.next;
        }

        public Node getTail() {
            return tail.prev;
        }
    }

}
