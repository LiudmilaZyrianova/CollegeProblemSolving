//169. Majority Element - E.
//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

import java.util.HashMap;
import java.util.Map;

public class Main {
    //Boyer-Moore Voting Algorithm:
//    public int majorityElement(int[] nums) {
//        int count = 0;
//        Integer candidate = null;
//
//        for (int num : nums) {
//            if (count == 0) {
//                candidate = num;
//            }
//            count += (num == candidate) ? 1 : -1;
//        }
//
//        return candidate;
//    }


    //Optimized:
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int major = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : nums){
            if (!map.containsKey(elem)){
                map.put(elem, 0);
            } else {
                int num = map.get(elem);
                if (num+1 >= major) return elem;
                map.put(elem, num+1);
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args){

    }

}

