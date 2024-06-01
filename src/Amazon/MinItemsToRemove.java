package Amazon;

import java.util.Arrays;

public class MinItemsToRemove {

    public static void main(String[] args) {
        int[] prices = {9, 6, 7, 2, 7, 2};
        int k = 2;
        int threshold = 13;
        System.out.println(minItemsToRemove(prices, k, threshold));
    }

    public static int minItemsToRemove(int[] prices, int k, int threshold) {
        Arrays.sort(prices);
        int n = prices.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += prices[n - i - 1];
        }
        int count = 0;
        while (sum > threshold && count < n) {
            System.out.println(prices[n - count - 1]);
            sum -= prices[n - count - 1];
            count++;
        }
        return count;
    }

}
