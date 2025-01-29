// 202. Happy Number - E
// bruteforce with set
    public boolean isHappy(int n) {
        // brute force:
        Set<Integer> store = new HashSet<>();
        store.add(n);
        while (true) {
            int temp = 0;
            while (n > 0) {
                temp += (n%10) * (n%10);
                n = n/10;
            }
            n = temp;
            if (n == 1) return true;
            if (store.contains(n)) return false;
            store.add(n);
        }
    }

// alt using fast and slow pointer and see if they cycle 19 → 82 → 68 → 100 → 1 

    public boolean isHappy(int n) {
        int slow = getNextNumber(n);
        int fast = getNextNumber(getNextNumber(n));

        while (slow != fast) {
            if (fast == 1) return true;
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }

        return slow == 1;
    }

    private int getNextNumber(int n) {
        int output = 0;
        
        while (n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n = n / 10;
        }
        
        return output;
    }
