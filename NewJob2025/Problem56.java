// 56. Merge Intervals - M
    public int[][] merge(int[][] intervals) {
        int[] temp = new int[10001];
        for (int i = 0; i < intervals.length; i++) {
            temp[intervals[i][0]] ++;
            temp[intervals[i][1]] --;
        }

        
        int posInterval = 0;
        int lP = 0;
        int rP = 0;
        int currVal;
        while (rP < 10001) {
            currVal = 0;
            while ((lP < 10001) && (temp[lP] == 0)) {
                lP++; rP++;
            }
            if (lP == 10001) break;
            currVal = temp[lP];
            while ((rP < 10001) && (currVal != 0)) {
                rP++;
                currVal += temp[rP];
            }
            if (currVal == 0) {
                int[] res1 = new int[]{lP, rP};
                intervals[posInterval] = res1;
                posInterval++;
            }

            lP = rP + 1;
            rP = rP + 1;
        }
        int[][] res = new int[posInterval][2];
        for (int i = 0; i < posInterval; i++) {
            res[i] = intervals[i];
        }
        return res;
    }


// MUCH BETTER SOLUTION
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
