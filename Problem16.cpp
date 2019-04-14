/*16. 3Sum Closest
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 Return the sum of the three integers. You may assume that each input would have exactly one solution.*/

#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int threeSumClosest(vector<int>& nums, int target) {
    int sum = nums[0]+nums[1]+nums[nums.size()-1];
    int temp = 0;
    sort(nums.begin(), nums.end());

    for (int i = 0; i< nums.size()-2; i++){
        int start = i+1;
        int end = nums.size()-1;
        while(start < end){
            temp = nums[i]+nums[start]+nums[end];
            if (abs(sum-target) > abs(temp - target)) sum = temp;
            if (temp > target) end--;
            else if (temp < target) start ++;
            else break;
        }
        if (abs(sum-target) > abs(temp - target)) sum = temp;
    }
    return sum;
};

int main() {
    vector<int> v = {1,2,5,10,11};
    int len = threeSumClosest(v, 12);
    cout << len << endl;
    return 0;
}
