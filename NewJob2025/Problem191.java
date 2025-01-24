// 191. Number of 1 Bits
    public int hammingWeight(int n) {
        int setBit = n % 2;
        int total = 0;
        int t = (int) (Math.log(n) / Math.log(2));
        for (int i = 0; i <= t; i++) {
            setBit = n % 2;
            total += setBit;
            n = (n-setBit)/2;
        }
        return total;
    }


// Much better solution!!!

public int hammingWeight(int n) {
        int count = 0;
        while (n != 0 ){
            count = count + (n & 1);
            n = n>>>1;
        }
        return count;
        
    }
