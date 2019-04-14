/*209. Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
 If there isn't one, return 0 instead.*/

#include <iostream>
#include <iostream>
#include <vector>
using namespace std;

int minSubArrayLen(vector<int>& nums, int s) {
    int sum = 0;
    int minLen = nums.size()+1;
    bool stop = false;
    int start = 0;
    for (int i = 0; i< nums.size(); i++){
        sum += nums[i];
        if (sum >= s) {
            stop = false;
            while (!stop) {
                if (sum - nums[start] >= s ){
                    sum -= nums[start];
                    start ++;
                } else {
                    stop = true;
                }
            }
            if (minLen > i-start) minLen = i-start+1;
        }

    }
    return (minLen == nums.size()+1) ? 0 : minLen;
};

int main() {
    vector<int> v = {2,3,1,2,4,3};
    int len = minSubArrayLen(v, 7);
    cout << len << endl;
//    for (int i = 0; i < len; i++) {
//        cout<<v[i]<< " ";
//    }
    return 0;
}
