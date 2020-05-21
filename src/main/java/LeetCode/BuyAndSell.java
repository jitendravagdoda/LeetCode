package LeetCode;

public class BuyAndSell {
    public static void main(String[] args) {
        int stockPrice[] = {2, 5, 7, 1, 4, 3, 1, 3};
        BuyAndSell bs=new BuyAndSell();
        System.out.println("Maximum Pofit "+bs.maxProfit(stockPrice,3));

    }

    public int maxProfit(int[] stockPrice, int k) {

        int profit[][] = new int[k + 1][stockPrice.length];

        for (int i = 1; i < profit.length; i++) {
            int maxDiff=-stockPrice[0];
            for(int j=1; j<profit[0].length; j++){
                profit[i][j]=Math.max(profit[i][j-1],stockPrice[j]+maxDiff);
                maxDiff=Math.max(maxDiff,profit[i-1][j]-stockPrice[j]);
            }
        }
        return profit[k][stockPrice.length-1];
    }
}
