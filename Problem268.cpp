/*268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
*/

#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
#include <deque>
#include <string>
using namespace std;

int missingNumber(vector<int>& nums) {
    int sum = 0;
    for (int num : nums){sum += num;}
    int total = nums.size()*(nums.size()+1)/2;
    return total-sum;
}

int main() {
    vector<int> nums = {3,0,1};
    int res = missingNumber(nums);
    cout<< res<<"\n";
//    for (auto elem : res) {
//        for (auto e : elem)
//            cout<< e << " ";
//        cout<<"\n";
//    }
    return 0;
}
