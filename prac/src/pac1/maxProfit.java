package pac1;

public class maxProfit {

    public static void main(String[] args) {
        int[] p = {7, 1, 5, 3, 6, 4};

    }

    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        // 保存当前最小值
        int min = prices[0];
        // 最大利润
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // 因为求最大利润，所以先计算最大利润，最终可减少一次比较
            max = Math.max(max, prices[i] - min);
            // 再计算最小历史
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /**
     * 多次交易，但交易不能重复
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 最大利润
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 利润等于之前所有的（后-前）
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
