package Greedy.CoinChange.java;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1000, 500, 100, 50, 20, 10, 2, 1};
        int sum = 11;

        System.out.println(minCoins(coins, sum));
    }    

    public static int minCoins(int[] coins, int sum){
        return minCoins(coins, sum, 0, 0);
    }

    public static int minCoins(int[] coins, int sum, int i, int count){
        if(sum == 0){
            return count;
        }

        if(i == coins.length){
            return -1;
        }

        while(i < coins.length && coins[i] > sum){
            i++;
        }

        if(i == coins.length){
            return -1;
        }

        int numOfCoins = (sum / coins[i]);
        int newSum = sum - numOfCoins * coins[i];

        return minCoins(coins, newSum, i + 1, count + numOfCoins);
    }
}
