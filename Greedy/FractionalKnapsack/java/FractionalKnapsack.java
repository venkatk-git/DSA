package Greedy.FractionalKnapsack.java;

import java.util.Arrays;

class Item implements Comparable<Item>{
    int value;
    int weight;

    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }

    @Override
    public int compareTo(Item item){
        double prevFrac = this.value / this.weight;
        double nextFrac = item.value / item.weight;

        return (int)(nextFrac - prevFrac);
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] items = {new Item(100, 20), new Item(60, 10), new Item(120, 30)};
        
        System.out.println(fractionalKnapsack(items, 50, items.length));
    }   
    
    public static double fractionalKnapsack(Item[] items, int weight, int n){
            double max = 0;
            double currWeight = 0;
            Arrays.sort(items);

            for(Item item : items){
                if(currWeight + item.weight <= weight){
                    currWeight += item.weight;
                    max += item.value;
                } else {
                    double accWeight = weight - currWeight;
                    max += ((double)item.value / (double)item.weight) * accWeight;
                    break;
                }
            }

            return max;
    }
}
