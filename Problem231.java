//231. Power of Two - E
//Given an integer, write a function to determine if it is a power of two.
   
   public boolean isPowerOfTwo(int n) {
        if (n == -2147483648) return false;
                int count = 0;
        while (n!=0){
            count = count+(n&1);
            n = n>>>1;
        }
        return count == 1;
    }
