package StacksAndQueues.Stack.LFUCache.java;

import java.util.HashMap;

class Node{
    public int key;
    public int val;
    public int freq;
    public Node next;
    public Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        freq = 1;
        next = null;
        prev = null;
    }

    public String toString(){
        return "{ Key : " + key + " Value : " + val+ " }";
    }
}

class LFUCache {
    public final HashMap<Integer, Node> cache;
    public final HashMap<Integer, Node[]> freq;
    public final int capacity;
    public int leastFreq;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        freq = new HashMap<>();
        leastFreq = 1;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            incFreq(node);

            
            if(freq.containsKey(node.freq)){
                Node head = freq.get(node.freq)[0];
                insertFirst(head, node);
            } else {
                freq.put(node.freq, newFrequency(node));
            }

            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            remove(node);
            incFreq(node);
            if(freq.containsKey(node.freq)){
                Node head = freq.get(node.freq)[0];
                insertFirst(head, node);
            } else {
                freq.put(node.freq, newFrequency(node));
            }

            return;
        }


        if(cache.size() >= capacity){
            removeLeast();
        }

        leastFreq = 1;

        Node node = new Node(key, value);
        cache.put(key, node);
        
        if(freq.containsKey(1)){
            System.out.println("Node : " + node);
            Node head = freq.get(1)[0];
            insertFirst(head, node);
        } else {
            System.out.println("Node : " + node);
            freq.put(1, newFrequency(node));
        }

    }

    public void incFreq(Node node){
        int oldFreq = node.freq;
        node.freq += 1;
        
        if(isEmptyList(freq.get(oldFreq))){
            freq.remove(oldFreq);
            if(oldFreq == leastFreq){
                leastFreq += 1;
            }
        }
    }

    public void insertFirst(Node head, Node node){
        Node prevNode = head.prev;
        if(prevNode != null){
            prevNode.next = node;
        }
        
        head.prev = node;
        node.next = head;
        node.prev = prevNode;
    }

    public Node[] newFrequency(Node node){
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        head.prev = node;
        node.next = head;
        node.prev = tail;
        tail.next = node;

        return new Node[]{head, tail};
    }

    public void remove(Node node){
        Node nextNode = node.next;
        if(nextNode != null){
            nextNode.prev = node.prev;
        }

        Node prevNode = node.prev;
        if(prevNode != null){
            prevNode.next = node.next;
        }

        node.next = null;
        node.prev = null;
    }

    public void removeLeast(){
        Node tail = freq.get(leastFreq)[1];
        Node node = tail.next;
        Node nextNode = node.next;
        

        tail.next = nextNode;
        if(nextNode != null){
            nextNode.prev = tail;
        }
        
        node.next = null;
        node.prev = null;

        cache.remove(node.key);

        if(isEmptyList(freq.get(leastFreq))){
            freq.remove(leastFreq);
        }
    }

    public boolean isEmptyList(Node[] nodes){
        Node head = nodes[0];
        Node tail = nodes[1];

        return head.prev == tail || tail.next == head;
    }
}

public class Main{
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);

        cache.put(2, 2);
        cache.put(1, 1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
    }
}