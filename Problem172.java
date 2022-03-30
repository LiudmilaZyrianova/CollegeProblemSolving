class Solution {
    public int getMaxFive(int n) {
        int c = 0;
        while (n % 5 == 0) {
            c++;
            n = n/5;
        }
        return c++;
        
    }
    
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                count = count + getMaxFive(i);
            }
        }
        return count;
    }
}

// Or we can keep dividing by 5 n/5 + n/25 +n/125...
