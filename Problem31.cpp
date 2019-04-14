/*31. Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).*/

#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void nextPermutation(vector<int>& nums) {
    int i;
    for (i =nums.size()-1; i>0; i--){
        if (nums[i]>nums[i-1]){
            int min = 100000000000;
            int p = i;
            for (int j = i; j < nums.size(); j++ ) {
                if ((nums[j]>nums[i-1]) && (nums[j]-nums[i-1]<min)) {
                    min = nums[j]-nums[i-1];
                    p = j;
                }
            }
            iter_swap(nums.begin() + p, nums.begin() + i-1);
            sort(nums.begin()+i, nums.end());
            break;
        }
    }
    if (i==0) sort(nums.begin(), nums.end());
}

int main() {
    vector<int> v = {2,3,1};
    nextPermutation(v);
    for (int i = 0; i < v.size(); i++) {
        cout<<v[i]<< " ";
    }
    return 0;
}
