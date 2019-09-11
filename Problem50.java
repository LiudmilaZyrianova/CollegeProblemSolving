//50. Pow(x, n) - M.
//Implement pow(x, n), which calculates x raised to the power n (xn).


import static java.lang.Math.abs;

public class Main {

    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(0.00001, 2147483647));
    }
}
