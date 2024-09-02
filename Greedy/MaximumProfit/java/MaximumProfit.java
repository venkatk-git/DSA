package Greedy.MaximumProfit.java;

import java.util.*;

class Item{
    int profit;
    int weight;
    float ratio;

    Item(int profit, int weight){
        this.profit = profit;
        this.weight = weight;
        this.ratio = (float)profit / weight;
    }

    @Override
    public String toString(){
        return("{Profit : " + profit + ", Weight : " + weight + ", Ratio : " + ratio + "}");
    }
}

class CompareWithRatio implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2) {
        if(o2.ratio > o1.ratio)
            return 1;
        
        return -1;
    }
}

public class MaximumProfit {
    public static void main(String[] args) {
        Item[] list = new Item[]{
            new Item(25, 18),
            new Item(24, 26),
            new Item(22, 19),
            new Item(12, 18),
            new Item(32, 15),
            new Item(15, 10)
        };

        System.out.println(maxProfit(list, 20, 2));
    }

    private static double maxProfit(Item[] itemList, int m, int n){
        Arrays.sort(itemList, new CompareWithRatio());

        double maxProfit = 0.0;
        int inBasket = 0;
        for(Item item : itemList){
            if(inBasket < m){
                maxProfit += item.profit;
            } 
        }

        return maxProfit;
    }
}
