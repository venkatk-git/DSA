package Backtracking.Hustle;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(3, 2));
    }
    
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        
        combine(n, k, 1, innerList, list);

        return list;
    };

    private static void combine(int n, int k, int i, List<Integer> innerList, List<List<Integer>> list) {
        if (innerList.size() == k) {
            list.add(new ArrayList<>(innerList));
            return;
        }

        if (i > n) {
            return;
        }

        // Calling with including the current element
        innerList.add(i);
        combine(n, k, i + 1, innerList, list);

        // Cleanup
        innerList.removeLast();

        // Calling without including the current element    
        combine(n, k, i + 1, innerList, list);
    }
}
