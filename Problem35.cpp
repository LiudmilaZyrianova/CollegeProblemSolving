//35. Search Insert Position - E. Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You may assume no duplicates in the array.

#include <iostream>
#include <vector>
using namespace std;

int searchInsert(vector<int>& nums, int target) {
    int low = 0;
    int high = nums.size()-1;

    if (high == -1) return 0;

    while (low < high) {
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            high = mid;
        } else {
            low = mid+1;
        }
    }
    if (nums[low] > target) return low;
    else if (nums[low] < target) return low+1;
    return low;

}

int main() {
    int k;

    vector<int> temp1;
    k = searchInsert(temp1, 0);
    cout<<k<<"\n";

    temp1.push_back(1);
    temp1.push_back(3);
    temp1.push_back(5);
    temp1.push_back(6);

    k = searchInsert(temp1, 5);
    cout<<k<<"\n";
    k = searchInsert(temp1, 2);
    cout<<k<<"\n";
    k = searchInsert(temp1, 7);
    cout<<k<<"\n";
    return 0;
}
