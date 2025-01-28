//69. Sqrt(x) - E
    public int mySqrt(int x) {
        // do bin search on all int by checking the result.
        if (x == 0) return 0;
        if (x == 1) return 1;
        double high = x;
        double low = 1;
        double mid = x;
        while (low <= high) {
            mid = low  + (int) ((high - low) / 2);
            if (mid * mid < (double) x) {
                low = mid + 1;
            } else if (mid * mid > (double) x) {
                high = mid - 1;
            } else if (mid * mid == (double) x) {
                return (int) mid;
            }
        }
        return (mid * mid < x) ? (int) mid : (int) (mid-1);
    }
