package DynamicProgramming;

public class DP_Medium_122_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int answer = maxProfit(prices);
        System.out.println(answer);
    }

    private static int maxProfit(int[] prices) {

        //idea
        //keep track of prevBuyPrice and currBuyPrice
        //we can either sell and add to our total or total = old buy price - currPrice

        //base cases
        if (prices.length == 1 || (prices.length == 2 && prices[0] >= prices[1])) {
            return 0;
        }
        if (prices.length == 2 && prices[0] < prices[1]) {
            return prices[1] - prices[0];
        }

        //dp
        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = (prices[1] < prices[0]) ? prices[0] - prices[1] : 0;

        int prevBuyPrice = 0;
        int currBuyPrice = 0;

        if (prices[1] < prices[0]) {
            prevBuyPrice = prices[0];
            currBuyPrice = prices[1];
        } else {
            prevBuyPrice = prices[0];
            currBuyPrice = prices[0];
        }


        for (int i = 2; i < prices.length; i++) {


            if (prices[i] > currBuyPrice) {
                int newBuy = prices[i] - currBuyPrice + dp[i - 2];
                int preBuy = currBuyPrice - prevBuyPrice;
                if (newBuy > preBuy) {
                    dp[i] = newBuy;
                    prevBuyPrice = currBuyPrice;
                    currBuyPrice = prices[i];
                } else {
                    dp[i] = preBuy;
                }
                //dp[i] = Math.max(currBuyPrice - prices[i] + dp[i - 2], prevBuyPrice - currBuyPrice);

            }

        }

        int max = 0;
        for(int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
