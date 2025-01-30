// 122. Best Time to Buy and Sell Stock II - M

    public int maxProfit(int[] prices) {
        int globalProfit = 0;

        int tempProfit = 0;
        int tempBuy = prices[0];

        int prevBuy = prices[0];
        int prevSell = prices[0];
        int prevProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            while ((i < prices.length - 1) && (prices[i] == prices[i+1])) {
                i++;
            }
            
            if (prices[i] < tempBuy) {
                tempBuy = prices[i];
            } else if (prices[i] - tempBuy > tempProfit) {
                tempProfit = prices[i] - tempBuy;

                if (((i < prices.length - 1) &&  (prices[i+1] < prices[i])) || (i == prices.length - 1)) {
                    if ((prevProfit >= 0) && (prices[i] - prevBuy > prevProfit + tempProfit)) {
                        prevBuy = prevBuy;
                        prevSell = prices[i];
                        globalProfit = globalProfit - prevProfit + prices[i] - prevBuy;
                        prevProfit = prices[i] - prevBuy;
                    } else {
                        globalProfit += tempProfit;
                        prevBuy = tempBuy;
                        prevSell = prices[i];
                        prevProfit = tempProfit;
                    }
                    
                    tempProfit = 0;
                    tempBuy = prices[i];
                    i--;
                    
                }
            }
        }

        return globalProfit;
    }



// MUCH EASIER _ JUST DO GREEDY AND APPEND ALL INCREMENTS
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;        
    }
