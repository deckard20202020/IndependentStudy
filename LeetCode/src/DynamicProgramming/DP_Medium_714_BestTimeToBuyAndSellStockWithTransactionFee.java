package DynamicProgramming;

public class DP_Medium_714_BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        int answer = maxProfit(prices, fee);
        System.out.println(answer);
    }

    private static int maxProfit(int[] prices, int fee) {

        //idea
        //At the end of the ith day, we maintain
        //cash-maximum profit we could have if we did not have a share of stock
        //hold-the maximum profit we could have if we owned a share of stock
        //to transition from the ith day to the ith + 1 day we either
        //sell -> cash = max(cash, hold + prices[i] - fee)
        //or buy -> hold = max(hold, cash - prices[i])
        //we want to return cash

        int cash = 0;
        int hold = -prices[0];

        for (int i = 0; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;

    }
}
