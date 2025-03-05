// 134. Gas Station - M

    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }

        int positive = 0; int negative = 0;
        int tempStart = -1;

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= 0) {
                if (tempStart == -1) {
                    tempStart = i;
                    positive = gas[i];
                } else {
                    positive += gas[i];
                }
            } else {
                if (tempStart != -1) {
                    if (positive + gas[i] >= 0) {
                        positive += gas[i];
                    } else {
                        negative += (positive + gas[i]);
                        tempStart = -1;
                        positive = 0;
                    }
                } else {
                    negative += gas[i];
                }
            }
        }

        if ((tempStart != -1) && (positive + negative >= 0)) return tempStart;

        return -1;
    }


// cleaner solution -- look only at surplus
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;
        
        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }
