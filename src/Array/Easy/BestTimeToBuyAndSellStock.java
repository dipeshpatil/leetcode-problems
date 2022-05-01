package Array.Easy;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
  public static void main(String[] args) {
    BestTimeToBuyAndSellStock o = new BestTimeToBuyAndSellStock();

    System.out.println(
      Arrays.toString(
        new int[]{
          o.maxProfit(new int[]{7, 1, 5, 3, 6, 4}),
          o.maxProfit(new int[]{7, 6, 4, 3, 1}),
        }
      )
    );
    // [5, 0]
  }

  public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice)
        minPrice = prices[i];
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
    }

    return maxProfit;
  }
}

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
