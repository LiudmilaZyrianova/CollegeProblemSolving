//8. String to Integer (atoi)- M.
//Implement atoi which converts a string to an integer.

import java.util.Stack;
public class Main {

    public static int myAtoi(String str) {
        while (str.length() != 0 && str.charAt(0) == ' ') {
            str = str.substring(1);
        }
        if (str.length() == 0) return 0;
        long res = 1;
        boolean neg = false;
        if (str.charAt(0) == '-') {
            neg = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            neg = false;
            str = str.substring(1);
        }
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0))) return 0;
        res = res*(str.charAt(0) - '0');
        int end = 1;
        int MAX_VAL = (int) Math.pow(2, 31);
        int MIN_VAL = (int) Math.pow(2, 31);
        while ( end < str.length() && Character.isDigit(str.charAt(end))){
            if (res > MAX_VAL) break;
            res = res*10 + (str.charAt(end) - '0');
            end++;
        }
        if (neg) res = -res;
        if (res > MAX_VAL) return MAX_VAL;
        if (res < (-1)*MIN_VAL) return (-1)*MIN_VAL-1;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi(" -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("9223372036854775808"));
    }
}
