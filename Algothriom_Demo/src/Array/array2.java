package Array;

public class array2 {
    public int maxProfit(int[] prices) {
        // 有差就卖以换取更多交易
        int  profit1 = 0;
        for(int i =1; i < prices.length; i ++){
            for(int j = i+1; j < prices.length; j ++)
                if (prices[j] > prices[i]){
                    profit1 = profit1 + (prices[j] - prices[i]);
                    i = j-1;
                    break;
                }
        }

        // 差最大才卖出
        int profit2 = 0;
        for(int i =1; i < prices.length; i ++){
            for(int j = i+1; j < prices.length; j ++){
                if (prices[j] - prices[i] > profit2){
                    profit2 = prices[j] - prices[i];
                    i = j-1;
                    break;
                }
            }
        }

        return Math.max(profit1, profit2);
    }
}

