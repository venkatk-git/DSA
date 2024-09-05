package SlidingWindowAnd2Pointers.FruitBasket.java;

/*
 * 904. Fruit Into Baskets.
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit.
 * There is no limit on the amount of fruit each basket can hold.
 * 
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) 
 * while moving to the right. The picked fruits must fit in one of your baskets.
 * 
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pic
 * 
 * Sample Input:
 * [1, 2, 3, 2, 2]
 * Output:
 * 4 
 * Explanation : [2, 3, 2, 2]
 */

public class FruitBasket {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(fruits));
    }
    
    private static int totalFruit(int[] fruits){
        int n = fruits.length;
        int l = 0, r = 0;
        int max = 0;

        int typeOne = -1;
        int typeTwo = -1;
        int typeOneCount = 0;
        int typeTwoCount = 0;

        while(r < n){
            if(typeOne == -1 && typeTwo != fruits[r])
                typeOne = fruits[r];
            else if(typeTwo == -1 && typeOne != fruits[r])
                typeTwo = fruits[r];
            
            if(fruits[r] == typeOne)
                typeOneCount++;
            
            else if(fruits[r] == typeTwo)
                typeTwoCount++;

            else {
                while(typeOneCount != 0 && typeTwoCount != 0){
                    if(fruits[l] == typeOne)
                        typeOneCount--;
                    else 
                        typeTwoCount--;
                    l++;
                }

                if(typeOneCount == 0){
                    typeOne = fruits[r];
                    typeOneCount = 1;
                } else {
                    typeTwo = fruits[r];
                    typeTwoCount = 1;
                }
                    
            }

            r++;
            max = Math.max(max, typeOneCount + typeTwoCount);
        }
        
        return max;
    }
}
