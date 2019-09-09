//374. Guess Number Higher or Lower - E.
//We are playing the Guess Game. The game is as follows:
//I pick a number from 1 to n. You have to guess which number I picked.
//Every time you guess wrong, I'll tell you whether the number is higher or lower.

import java.util.PriorityQueue;

public class Main {

    public static int guess(int num) {
        if (num == 5) return 0;
        else return (num > 5) ? -1 : 1;
    }

    public static int guessNumber(int n) {
        if (n==1) return 1;
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(guessNumber(2));
    }
}
