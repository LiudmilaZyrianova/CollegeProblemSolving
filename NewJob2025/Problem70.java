//70. Climbing Stairs
// DP - no need for recursion - store 

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int prM2 = 1;
        int prM1 = 2;
        int res = 0;
        while (n > 2) {
            res = prM1 + prM2;
            prM2 = prM1;
            prM1 = res;
            n--;
        }
        return res;
    }
