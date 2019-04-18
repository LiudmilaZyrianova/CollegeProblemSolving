/*128. Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
*/

#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
#include <deque>
#include <string>
using namespace std;


int longestConsecutive(vector<int>& nums) {
    vector<int> t;
    for (int i=0; i<nums.size(); i++) {
        t.push_back(nums[i]);
    }
    sort(t.begin(), t.end());
    int maxLen = 1;
    if (nums.size()==0) maxLen = 0;
    int currLen=1;
    for (int i=1; i< t.size(); i++){
        if (t[i] == t[i-1]+1){
            currLen++;
            if (currLen > maxLen) maxLen = currLen;
        } else if (t[i] == t[i-1]){

        } else {
            currLen = 1;
        }
    }

    return  maxLen;

}

//Better Solution in Java
//class Solution {
//public int longestConsecutive(int[] nums) {
//        Set<Integer> num_set = new HashSet<Integer>();
//        for (int num : nums) {
//            num_set.add(num);
//        }
//
//        int longestStreak = 0;
//
//        for (int num : num_set) {
//            if (!num_set.contains(num-1)) {
//                int currentNum = num;
//                int currentStreak = 1;
//
//                while (num_set.contains(currentNum+1)) {
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//
//                longestStreak = Math.max(longestStreak, currentStreak);
//            }
//        }
//
//        return longestStreak;
//    }
//}

int main() {
    vector<int> nums = {100, 1, 200, 4 , 3, 2};
    int res = longestConsecutive(nums);
    cout<< res<<"\n";
    return 0;
}
