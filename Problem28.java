//28. Valid Palindrome - E. Given a string, determine if it is a palindrome,
// considering only alphanumeric characters and ignoring cases.
//Note: For the purpose of this problem, we define empty string as valid palindrome.

public class Main {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int n = needle.length();
        if (n > haystack.length()) return -1;
        if (n == haystack.length()) {
            return (haystack.equals(needle)) ? 0 : -1;
        }
        for (int i = 0; i <= haystack.length() - n; i++){
            if (haystack.substring(i, i+n).equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("mississippi","pi"));

    }
}
