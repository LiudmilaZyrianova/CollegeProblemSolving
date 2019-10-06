//136. Single Number - E.
//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
import java.util.Arrays;

public class Main {
    //Better solution: So we can XOR(^) //==0 if the same, ==x if (0^x)// all bits together to find the unique number.
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        for (int i = 1; i<nums.length; i= i+2){
            if (nums[i]!=nums[i-1]) return nums[i];
        }
        return 0;

    }

    public static void main(String[] args){

    }

}

