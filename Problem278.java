//278. First Bad Version - E.
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
// which causes all the following ones to be bad.

public class Main {

    public static boolean isBadVersion(int version) {
        return (version > 2);
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        //System.out.println(firstBadVersion(1));
        //System.out.println(firstBadVersion(2));
        System.out.println(firstBadVersion(10));
    }
}
