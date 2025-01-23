// 9. Palindrome Number
    public boolean isPalindrome(int x) {
        // without converting to a string - div by 10
        if (x < 0) { return false;}
        int numFromRight = 0;
        int numFromLeft = 0;
        int maxPow = (int) Math.log10(x);
        int powLeft = 1;
        int powRight = (int) Math.pow(10, maxPow);
        for (int i = 0; i < (maxPow + 1) / 2; i++) {
            numFromRight = ((int) x / powLeft) % 10;
            numFromLeft = ((int) x / powRight) % 10;
            if (numFromRight != numFromLeft) return false;
            powLeft = powLeft * 10;
            powRight = powRight / 10;
        }
        return true;
    }


// slightly better solution - reverse the number using % and /
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int xcopy = x;

        while (x > 0) {
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }

        return reverse == xcopy;        
    }
