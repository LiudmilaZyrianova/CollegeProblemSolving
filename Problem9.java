//9. Palindrome Number - E.
//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

public class Main {

    //Compute reverse 
//    public boolean isPalindrome(int x) {
//        if (x<0 || (x!=0 && x%10==0)) return false;
//        int rev = 0;
//        while (x>rev){
//            rev = rev*10 + x%10;
//            x = x/10;
//        }
//        return (x==rev || x==rev/10);
//    }
    
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int powL = 0;
        int topTen = (int) Math.pow(10, (int) Math.log10(x));
        while (topTen > 0) {
            if (x%10 != x/topTen) return false;
            x = x%topTen;
            x = x/10;
            topTen = topTen/100;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(313));
    }
}
