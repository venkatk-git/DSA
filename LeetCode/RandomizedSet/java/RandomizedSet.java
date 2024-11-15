package LeetCode.RandomizedSet.java;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    int i;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        i = 0;
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }

        map.put(val, i);
        list.add(val);
        i += 1;
        return true;
    }   
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int removedIndex = map.get(val);
        map.remove(val);
        list.set(removedIndex, list.removeLast());
        return true;
    }
    
    public int getRandom() {
        int index = (int)Math.random() * list.size();
        return list.get(index); 
    }
}

class Main {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.remove(2));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
    }
    
}
 