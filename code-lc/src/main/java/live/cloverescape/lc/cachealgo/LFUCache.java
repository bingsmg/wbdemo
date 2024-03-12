package live.cloverescape.lc.cachealgo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 * @date 2023-11-08
 */
class LFUCache {

    public static void main(String[] args) {
        LFUCache lruCache = new LFUCache(2);
        lruCache.put(1, 1);
        lruCache.put(3, 1);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(2));
    }

    int capacity;
    Map<Integer, Node> keyMap;
    Map<Integer, DLinkedList> freqMap;
    int minFreq;

    public int get(int key) {
        if (capacity == 0) return -1;
        if (!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        update(key, node.val, node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (!keyMap.containsKey(key)) {
            if (keyMap.size() == capacity) {
                DLinkedList list = freqMap.get(minFreq);
                keyMap.remove(list.getTail().key);
                list.delTail();
                if (freqMap.get(minFreq).size == 0) {
                    freqMap.remove(minFreq);
                }
            }
            DLinkedList list = freqMap.getOrDefault(1, new DLinkedList());
            list.addHead(new Node(key, value, 1));
            freqMap.put(1, list);
            keyMap.put(key, freqMap.get(1).getHead());
            minFreq = 1;
        } else {
            Node node = keyMap.get(key);
            update(key, value, node);
        }
    }

    /**
     * 根据 key 和 val 更新 node 的值及在哈希表中的位置
     * 如果是 get 则没有改变，put 则需要传新的 val
     * @param key key
     * @param val val
     * @param node node
     */
    private void update(int key, int val, Node node) {
        int freq = node.freq;
        freqMap.get(freq).delNode(node);
        if (freqMap.get(freq).size == 0) {
            freqMap.remove(freq);
            if (freq == minFreq) {
                minFreq += 1;
            }
        }
        DLinkedList list = freqMap.getOrDefault(freq + 1, new DLinkedList());
        list.addHead(new Node(key, val, freq + 1));
        freqMap.put(freq + 1, list);
        keyMap.put(key, freqMap.get(freq + 1).getHead());
    }

    private static class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        Node() {}
        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    private static class DLinkedList {
        private final Node head;
        private final Node tail;
        int size;

        DLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        Node getHead() { return head.next; }
        Node getTail() { return tail.prev; }

        void delNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
        }

        void addHead(Node node) {
            node.next = head.next;
            node.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }

        void delTail() {
            delNode(tail.prev);
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
}