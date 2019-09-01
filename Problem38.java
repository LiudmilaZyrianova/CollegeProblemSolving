//38. Count and Say - E. The count-and-say sequence is the sequence of integers with the first five terms as following:
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

public class Main {

    public static String helper(String s) {
        if (s.equals("1")) return "11";
        String temp = "";
        char[] t = s.toCharArray();
        int i = 0;
        while (i < t.length - 1) {
            int count = 1;
            while (t[i] == t[i+1]){
                count++;
                if (i < t.length - 2) i++;
                else break;
            }
            temp = temp.concat(String.valueOf(count));
            temp = temp.concat(String.valueOf(t[i]));
            i++;
        }
        if (t[t.length-2] != t[t.length-1]) {
            temp = temp.concat(String.valueOf(1));
            temp = temp.concat(String.valueOf(t[t.length-1]));
        }

        return temp;
    }

    public static String countAndSay(int n) {
        if ( n == 1 ) return "1";
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = helper(res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
}
