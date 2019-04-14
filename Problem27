/*27. Remove Element
Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length*/

#include <iostream>
#include <iostream>
#include <vector>
using namespace std;

int removeElement(vector<int>& nums, int val) {
    int i = 0;
    int l = nums.size();
    while (i < l)
    {
        if (nums[i] == val){
            nums.erase(nums.begin()+i);
            l--;
        } else {
            i++;
        }
    }
    return l;
};

int main() {
    vector<int> v = {0,1,2,2,3,0,4,2};
    int len = removeElement(v, 2);
    cout << len << endl;
    for (int i = 0; i < len; i++) {
        cout<<v[i]<< " ";
    }
    return 0;
}
