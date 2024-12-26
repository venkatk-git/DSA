package Math.Breeze;

import cputils.FastReader;

public class CoinTransformation {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        for(int i = 0; i < n; i++) {
            long coin = fastReader.nextLong();
            System.out.println(transformCoin(coin));
        }
    }    

    public static long transformCoin(long coin) {
        if(coin < 3) {
            return coin;
        }

        long remainingCoin = coin / 4;

        return 2 + (remainingCoin > 3 ? transformCoin(remainingCoin) : 0);
    }
}
