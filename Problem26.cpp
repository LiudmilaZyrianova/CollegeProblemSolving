//26. Remove Duplicates from Sorted Array. Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

#include <iostream>
#include <iostream>
#include <vector>
using namespace std;

int removeDuplicates(vector<int>& nums) {
    int i = 0;
    int l = nums.size();
    while (i < l-1)
    {
        if (nums[i] == nums[i+1]){
            nums.erase(nums.begin()+i+1);
            l--;
        } else {
            i++;
        }
    }
    return l;
};

int main() {
    vector<int> v = {0,0,1,1,1,2,2,3,3,4};
    int len = removeDuplicates(v);
    cout << len << endl;
    for (int i = 0; i < len; i++) {
        cout<<v[i]<< " ";
    }
    return 0;
}
