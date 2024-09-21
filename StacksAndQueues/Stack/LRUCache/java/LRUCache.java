package StacksAndQueues.Stack.LRUCache.java;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

class Node {
    SimpleEntry<Integer, Integer> entry;
    Node next;
    Node prev;

    Node(int key, int value){
        entry = new SimpleEntry<>(key,value);
        this.next = null;
        this.prev = null;
    }

    public int getAndUpdate(Node head){
        Node prevNode = prev;
        Node nextNode = next;

        nextNode.prev = prev;
        prevNode.next = next;

        prevNode = head.prev;
        prevNode.next = this;
        head.prev = this;
        next = head;
        prev = prevNode;

        return entry.getValue();
    }

    public String toString(){
        return " { Key : " + entry.getKey() + ", value : " + entry.getValue() + " }";
    }
}

public class LRUCache {
    private final HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;
    private final int capacity;

    
    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.prev = tail;
        tail.next = head;
    }    

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }

        Node node = cache.get(key);

        Node prevNode = node.prev;
        Node nextNode = node.next;

        nextNode.prev = node.prev;
        prevNode.next = node.next;

        prevNode = head.prev;
        prevNode.next = node;
        
        head.prev = node;
        node.next = head;
        node.prev = prevNode;

        System.out.println(cache);
        
        return node.entry.getValue();
    }
    
    public void put(int key, int value){
        if(cache.containsKey(key)){
            update(cache.get(key), key, value);
            System.out.println(cache);
            return;
        }

        if(cache.size() < capacity){
            Node node = insertFirst(key, value);
            cache.put(key, node);
            System.out.println(cache);
            return;
        }

        removeLast();
        Node node = insertFirst(key, value);
        cache.put(key, node);
        System.out.println(cache);
    }

    public void update(Node node, int key, int newValue){
        node.entry = new SimpleEntry<>(key, newValue);

        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        nodeNext.prev = nodePrev;
        nodePrev.next = nodeNext;

        Node headPrev = head.prev;
        node.next = head;
        node.prev = headPrev;
        headPrev.next = node;
        head.prev = node;
    }

    public Node insertFirst(int key, int value){
        Node node = new Node(key, value);
        
        Node headPrev = head.prev;
        
        headPrev.next = node;
        node.prev = headPrev;
            
        head.prev = node;
        node.next = head;

        return node;
    }

    public void removeLast(){
        if(tail.next != null){
            Node node = tail.next;
         
            Node newNext = tail.next.next;
            newNext.prev = tail;
            tail.next = newNext;
         
            node.next = null;
            node.prev = null;
            cache.remove(node.entry.getKey());
        }
    }
}

class UseLRUCache{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        
    }
}

