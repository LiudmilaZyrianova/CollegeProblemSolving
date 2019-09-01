//67. Add Binary - E. Given two binary strings, return their sum (also a binary string).
//The input strings are both non-empty and contains only characters 1 or 0.

public class Main {

    public static  String addBinary(String a, String b) {
        int f = a.length()-1;
        int s = b.length()-1;
        String res = "";
        int overload = 0;
        int t = 0;
        while (f >= 0 && s>=0) {
            t = Character.getNumericValue(a.charAt(f))+ Character.getNumericValue(b.charAt(s)) + overload;
            if (t >= 2) {
                overload = 1;
                res = res.concat(String.valueOf(t-2));
            } else {
                overload = 0;
                res = res.concat(String.valueOf(t));
            }
            f--;
            s--;
        }
        while (f >= 0 ) {
            t = Character.getNumericValue(a.charAt(f)) + overload;
            if (t >= 2) {
                overload = 1;
                res = res.concat(String.valueOf(t-2));
            } else {
                overload = 0;
                res = res.concat(String.valueOf(t));
            }
            f--;
        }
        while (s >= 0 ) {
            t = Character.getNumericValue(b.charAt(s)) + overload;
            if (t >= 2) {
                overload = 1;
                res = res.concat(String.valueOf(t-2));
            } else {
                overload = 0;
                res = res.concat(String.valueOf(t));
            }
            s--;
        }
        if (overload == 1){
            res = res.concat("1");
        }
        StringBuilder input1 = new StringBuilder();
        input1.append(res);
        input1 = input1.reverse();
        res = input1.toString();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("1111", "1111"));

    }
}
