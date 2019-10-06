//342. Power of Four - E
//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

public class Main {
    public static boolean isPowerOfFour(int num) {
        if (num == 0 ) return false;
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args){
        System.out.println(isPowerOfFour(8));
        System.out.println(isPowerOfFour(16));

    }

}

