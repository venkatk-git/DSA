package Greedy.LemonadeChange.java;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};

        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills){
        int fives = 0;
        int tens = 0;

        for(int bill : bills){
            switch (bill) {
                case 5 -> fives += 1;
                case 10 -> {
                    if(fives == 0){
                        return false;
                    }
                    fives -= 1;
                    tens += 1;
                }
                case 20 -> {
                    if(tens == 0){
                        if(fives >= 3){
                            fives -= 3;
                        } else {
                            return false;
                        }
                    } else {
                        if(fives >= 1){
                            fives -= 1;
                            tens -= 1;
                        } else {
                            return false;
                        }
                    }
                }
                default -> {
                    return false;
                }
            }
        }

        return true;
    }
    
}