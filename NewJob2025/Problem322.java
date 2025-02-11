// 322. Coin Change - M

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

    //     better sol 
    int coinChange(vector<int>& coins, int n) {
        // creating the base dp array, with first value set to 0
        int dp[++n];
        dp[0] = 0;
        // more convenient to have the coins sorted
        sort(begin(coins), end(coins));
        // populating our dp array
        for (int i = 1; i < n; i++) {
            // setting dp[0] base value to 1, 0 for all the rest
            dp[i] = INT_MAX;
            for (int c: coins) {
                if (i - c < 0) break;
                // if it was a previously not reached cell, we do not add use it
                if (dp[i - c] != INT_MAX) dp[i] = min(dp[i], 1 + dp[i - c]);
            }
        }
        return dp[--n] == INT_MAX ? -1 : dp[n];
    }
