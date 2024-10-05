package LinkedList;

/*
  Problem: Design a data structure that follows the constraints of Least Recently Used (LRU) cache.
  <p>
  The LRUCache class has two methods:
  1. int get(int key):
       - Returns the value of the key if the key exists in the cache, otherwise returns -1.
  2. void put(int key, int value):
       - Updates the value of the key if the key exists.
       - Otherwise, adds the key-value pair to the cache.
       - If the number of keys exceeds the capacity, evict the least recently used key.
  <p>
  Constraints:
  - The `get` and `put` operations must each run in O(1) average time complexity.
  - The capacity of the cache is given during initialization and must be respected.
  <p>
  Approach:
  - To achieve O(1) time complexity, we use two data structures:
    1. HashMap<Integer, Node> cache:
         - The HashMap stores key-to-node mappings for O(1) access to cache elements.
    2. Doubly Linked List:
         - This maintains the order of least recently used elements, with the most recently used at the front
           (head) and the least recently used at the back (tail). Evictions are done from the tail.
         - Each node in the doubly linked list contains key-value pairs and pointers to the next and previous nodes.
  <p>
  Example Execution:
  1. Initialize with capacity 2.
     Doubly Linked List: [head] <-> [tail]
     HashMap: {}
  <p>
  2. put(1, 1)
     - Add key 1 with value 1.
     Doubly Linked List: [head] <-> (1,1) <-> [tail]
     HashMap: {1 -> Node(1, 1)}
  <p>
  3. put(2, 2)
     - Add key 2 with value 2.
     Doubly Linked List: [head] <-> (2,2) <-> (1,1) <-> [tail]
     HashMap: {1 -> Node(1, 1), 2 -> Node(2, 2)}
  <p>
  4. get(1)
     - Return value 1. Move key 1 to the front.
     Doubly Linked List: [head] <-> (1,1) <-> (2,2) <-> [tail]
     HashMap: {1 -> Node(1, 1), 2 -> Node(2, 2)}
  <p>
  5. put(3, 3)
     - Add key 3, evict key 2 (least recently used).
     Doubly Linked List: [head] <-> (3,3) <-> (1,1) <-> [tail]
     HashMap: {1 -> Node(1, 1), 3 -> Node(3, 3)}
  <p>
  6. get(2)
     - Key 2 was evicted, return -1.
     Doubly Linked List: [head] <-> (3,3) <-> (1,1) <-> [tail]
     HashMap: {1 -> Node(1, 1), 3 -> Node(3, 3)}
  <p>
  7. put(4, 4)
     - Add key 4, evict key 1 (least recently used).
     Doubly Linked List: [head] <-> (4,4) <-> (3,3) <-> [tail]
     HashMap: {3 -> Node(3, 3), 4 -> Node(4, 4)}
  <p>
  8. get(1)
     - Key 1 was evicted, return -1.
  <p>
  9. get(3)
     - Return value 3. Move key 3 to the front.
     Doubly Linked List: [head] <-> (3,3) <-> (4,4) <-> [tail]
     HashMap: {3 -> Node(3, 3), 4 -> Node(4, 4)}
  <p>
  10. get(4)
     - Return value 4.
     Doubly Linked List: [head] <-> (3,3) <-> (4,4) <-> [tail]
     HashMap: {3 -> Node(3, 3), 4 -> Node(4, 4)}
  <p>
  Time Complexity:
  - Both `get` and `put` operations are O(1) on average because the HashMap provides O(1) lookups, and the doubly
    linked list allows for O(1) insertion, deletion, and updating.
 */

import java.util.HashMap;

public class LRUCache {

    // Define the Node structure for the Doubly Linked List
    static class Node {
        int key;
        int value;
        Node prev, next;

        // Node constructor
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Capacity of the cache and current size
    private final int capacity;
    private int size;
    private final HashMap<Integer, Node> cache; // Maps keys to nodes
    private final Node head, tail; // Dummy head and tail for the doubly linked list

    // Constructor to initialize cache with a given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();

        // Create dummy head and tail nodes to avoid null checks
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Retrieves the value for a given key.
     * If the key exists in the cache, the node is moved to the front (most recently used).
     * If the key does not exist, return -1.
     *
     * @param key the key to be retrieved
     * @return the value associated with the key, or -1 if the key is not found
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1; // Return -1 if key is not found
        }
        // Move the accessed node to the front (mark as recently used)
        moveToHead(node);
        return node.value;
    }

    /**
     * Inserts or updates a value for a given key in the cache.
     * If the key already exists, the value is updated and the node is moved to the front.
     * If the key does not exist, a new node is created. If the cache exceeds its capacity, 
     * the least recently used key is evicted.
     *
     * @param key the key to be inserted or updated
     * @param value the value to be associated with the key
     */
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // If key is not present, create a new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;

            // If size exceeds capacity, remove the least recently used item
            if (size > capacity) {
                Node tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        } else {
            // If key exists, update the value and move it to the front
            node.value = value;
            moveToHead(node);
        }
    }

    // Helper function to move a node to the front (just after the head)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Helper function to add a node just after the head
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Helper function to remove a node from its current position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper function to remove the tail node (least recently used)
    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}

// Example to test the LRUCache
class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        // Perform operations
        lruCache.put(1, 1); // Cache is {1=1}
        lruCache.put(2, 2); // Cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // Returns 1
        lruCache.put(3, 3); // Evicts key 2, Cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // Returns -1 (not found)
        lruCache.put(4, 4); // Evicts key 1, Cache is {4=4, 3=3}
        System.out.println(lruCache.get(1)); // Returns -1 (not found)
        System.out.println(lruCache.get(3)); // Returns 3
        System.out.println(lruCache.get(4)); // Returns 4
    }
}