//58. Length of Last Word - E. Given a string s consists of upper/lower-case alphabets
// and empty space characters ' ', return the length of last word in the string.
//If the last word does not exist, return 0.
//Note: A word is defined as a character sequence consists of non-space characters only.

public class Main {

    // small 
//    public int lengthOfLastWord(String s) {
//        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
//    }
    
    public static int lengthOfLastWord(String s) {
        if (s.isEmpty()) return 0;
        int p = s.length()-1;
        int size = 0;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }
        while (p >= 0 && s.charAt(p) != ' ') {
            size++;
            p--;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));    //5
        System.out.println(lengthOfLastWord("a"));    //1
        System.out.println(lengthOfLastWord("a "));    //1
        System.out.println(lengthOfLastWord(""));    //0
        System.out.println(lengthOfLastWord("  "));    //0

    }
}
