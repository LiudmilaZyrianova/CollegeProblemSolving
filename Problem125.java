//125. Valid Palindrome - E. Given a string, determine if it is a palindrome,
// considering only alphanumeric characters and ignoring cases.
//Note: For the purpose of this problem, we define empty string as valid palindrome.

public class Main {

    //Optimized solution:
//    public boolean isPalindrome(String s) {
//        if (s.isEmpty()) {
//            return true;
//        }
//        int head = 0, tail = s.length() - 1;
//        char cHead, cTail;
//        while(head <= tail) {
//            cHead = s.charAt(head);
//            cTail = s.charAt(tail);
//            if (!Character.isLetterOrDigit(cHead)) {
//                head++;
//            } else if(!Character.isLetterOrDigit(cTail)) {
//                tail--;
//            } else {
//                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
//                    return false;
//                }
//                head++;
//                tail--;
//            }
//        }
//
//        return true;
//    }

    public static  boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        for (int i = 0; i < s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));

    }
}
