// 66. Plus One


    public int[] plusOne(int[] digits) {
        int carryOver = 0;
        int tempRes = 0;
        int i = digits.length - 1;
        tempRes = digits[i] + 1;
        digits[i] = tempRes % 10;
        carryOver = tempRes / 10;
        i--;
        while ((i >= 0) && (carryOver == 1)) {
            tempRes = digits[i] + carryOver;
            digits[i] = tempRes % 10;
            carryOver = tempRes / 10;
            i--;
        }

        if ((i == -1) && (carryOver == 1)) {
            int[] newArray = Arrays.copyOf(digits, digits.length + 1);
            newArray[0] = 1;
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            return newArray;
        }

        return digits;
    }

// better solution!! - just look at 9s and change to 0s. othervise init new array of 0 and set first elem to 1
for (int i = digits.length - 1; i >= 0; i--) {
	if (digits[i] < 9) {
		digits[i]++;
		return digits;
	}
	digits[i] = 0;
}

digits = new int[digits.length + 1];
digits[0] = 1;
return digits;
