package Arrays;

public class MaxProfitByBuyingAndSelling {
    public int maxProfit(int[] prices) {
        // Initialize minPrice to the maximum integer value
        int minPrice = Integer.MAX_VALUE;
        // Initialize maxProfit to 0
        int maxProfit = 0;
        // Iterate over the prices array
        for (int i = 0; i < prices.length; i++) {
            // If the current price is less than minPrice, update minPrice
            if (prices[i] < minPrice)
                minPrice = prices[i];
                // If the current price minus minPrice is greater than maxProfit, update maxProfit
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        // Return the maximum profit
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfitByBuyingAndSelling solution = new MaxProfitByBuyingAndSelling();
        int[] prices = {2,7,5,3,6,4};
        System.out.println(solution.maxProfit(prices)); // Output: 5

        prices = new int[]{7,6,4,3,1};
        System.out.println(solution.maxProfit(prices)); // Output: 0
    }
}