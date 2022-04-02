class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) { return tasks.length; }
        int[] amounts = new int[26];
        for (char t : tasks) {
            amounts[t - 'A']++;
        }
        n = n+1;
        int units = 0;
        Arrays.sort(amounts);
        // for (int in : amounts) {System.out.print(in);}
        while (amounts[25] != 0) {
            // create a block
            int i = 25;
            int j = 0;
            while (i > -1 && amounts[i] > 0 && j < n) {
                // put one in the block
                amounts[i]--;
                i--;
                j++;
                units++;
            }
            
            if ((i == -1 || amounts[i] == 0) && amounts[25] != 0 && j < n) {
                units = units + n-j;
            }
            
            Arrays.sort(amounts);
        }

        return units;
        
    }
}

// Better solution - instead of resorting, use Priority Queue!!!
