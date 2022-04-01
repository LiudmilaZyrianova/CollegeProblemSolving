class Solution {
    public boolean cont(int[] coins, int val) {
        for (int c: coins) {
            if (val == c) return true;
        }
        return false;
    }
    
    public int sortedCoinChange(int[] coins, int amount, int[] tempRes) {
        if (amount < coins[0]) {return -1;}
        if (tempRes[amount] != 0) {
            return tempRes[amount];
        }
        
        if (cont(coins, amount)) {
            tempRes[amount] = 1;
            return 1;
        }
        int minVal = 100000;
        for (int coin : coins) {
            int t = sortedCoinChange(coins, amount-coin, tempRes);
            if (t != -1) {
                minVal = Math.min(minVal, t);
            }
        }
        if (minVal == 100000) {
            tempRes[amount] = -1;
            return -1;
        }
        tempRes[amount] = minVal + 1;
        return minVal + 1;
        
    }
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] tempRes = new int[amount + 1];
        Arrays.sort(coins);
        return sortedCoinChange(coins, amount, tempRes);
    }
}
