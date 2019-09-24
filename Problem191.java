//191. Number of 1 Bits - E.
//Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0 ){
            count = count + (n & 1);
            n = n>>>1;
        }
        return count;
        
    }
