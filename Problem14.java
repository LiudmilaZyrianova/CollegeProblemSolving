//14. Longest Common Prefix - E. Write a function to find the longest common prefix
// string amongst an array of strings.
// If there is no common prefix, return an empty string "".

public class Main {

    public static String prefix(String s1, String s2) {
        int i1 = 0;
        int min = (s1.length() >  s2.length()) ? s2.length() : s1.length();
        while (i1 <  min  && s1.charAt(i1) == s2.charAt(i1)) {
            i1++;
        }
        return s1.substring(0, i1);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++){
            res = prefix(res, strs[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] a1 = new String[] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(a1));    //"fl"
        String[] a2 = new String[] {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(a2));    //""
    }
}
