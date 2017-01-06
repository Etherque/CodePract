/* Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set. get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
    private int capacity;
    private Node head, tail;
    private Map<Integer, Node> map = new HashMap<>();
    
    public static class Node {
        int key, value;
        Node prev, next;
        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        linkNodeLast(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if(node == null) {
            node = new Node(key, value);
        } else {
            node.value = value;
        }
        map.put(key, node);
        linkNodeLast(node);
        if(map.size() > capacity) {
            Node item = head.next;
            head.next = item.next;
            item.next.prev = head;
            map.remove(item.key);
        }
    }
    
    private void linkNodeLast(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
}











