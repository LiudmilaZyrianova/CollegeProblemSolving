//7. Reverse Integer - E.
//Given a 32-bit signed integer, reverse digits of an integer.
public class Main {

    public static int reverse(int x) {
        boolean neg = (x < 0);
        if (neg) x = -x;
        long res = 0;
        while (x > 0){
            res = res*10 + x%10;
            x = x/10;
        }
        if (neg) res = -res;
        if (res > (int) Math.pow(2,31) || res < (int) -Math.pow(2,31)) return 0;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469)); //0

    }
}
