package LeetCode.DungeonHP.java;

import java.util.Arrays;

class DungeonHP {
    static int[] possibleOutput = new int[2];
    static int index = 0;

    public static void main(String[] args){
        int[][] dungeon = {{-3, 5}};
        System.out.println(calculateMinimumHP(dungeon));
        System.out.println(Arrays.toString(possibleOutput));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        _calculateMinimumHP(dungeon, dungeon.length, dungeon[0].length, 0);

        int nearZero = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < index; i++){
            if(Math.abs(possibleOutput[i]) < nearZero){
                nearZero = Math.abs(possibleOutput[i]);
                if(possibleOutput[i] < 0)
                    res = Math.abs(possibleOutput[i]) + 1;
                else 
                    res = 1;
            }
        }

        return res;
    }

    public static void _calculateMinimumHP(int[][] dungeon, int m, int n, int health){
        if(m == 1 && n == 1){
            possibleOutput[index++] = health + dungeon[m - 1][n - 1];
            return;
        }
        
        int currHealth = 0;

        if(dungeon[m - 1][n - 1] < 0){
            currHealth += (dungeon[m - 1][n - 1] * -1) + 1;
            System.out.println(currHealth);
        } else{
            currHealth += dungeon[m - 1][n - 1];
            System.out.println(currHealth);
        } 
        
        System.out.println(Arrays.toString(possibleOutput));

        if(m > 1)
            _calculateMinimumHP(dungeon, m - 1, n, health + currHealth);
        if(n > 1)
            _calculateMinimumHP(dungeon, m, n - 1, health + currHealth);
    }
}