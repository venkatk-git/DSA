package Greedy.Candy.java;

class Solution {
    public int candy(int[] ratings){
        int n = ratings.length;
        int candies = 1;

        int i = 1;
        while(i < n){
            if(ratings[i] == ratings[i - 1]){
                candies += 1;
                i++;
                continue;
            }

            int peek = 1;
            while(i < n && ratings[i] > ratings[i - 1]){
                peek += 1;
                candies += peek;
                i++;
            }

            int down = 1;
            while(i < n && ratings[i] < ratings[i - 1]){
                candies += down;
                down += 1;
                i++;
            }

            if(down > peek){
                candies += down - peek;
            }
        }

        return candies;
    }
}

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,3,2,2,1};

        Solution solution = new Solution();
        System.out.println(solution.candy(ratings));
    }
}
