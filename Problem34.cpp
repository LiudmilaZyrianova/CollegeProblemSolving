//34. Find First and Last Position of Element in Sorted Array - M.  Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].

#include <iostream>
#include <vector>
using namespace std;

int extremeInsertionIndex(vector<int>& nums, int target, bool left) {
    int low = 0;
    int high = nums.size();

    while (low < high) {
        int mid = (low + high) / 2;
        if (nums[mid] > target || (left && target == nums[mid])) {
            high = mid;
        }
        else {
            low = mid+1;
        }
    }
    return low;
}

vector<int> searchRange(vector<int>& nums, int target) {
    vector<int> range = {-1, -1};

    int leftIdx = extremeInsertionIndex(nums, target, true);

    // assert that `leftIdx` is within the array bounds and that `target`
    // is actually in `nums`.
    if (leftIdx == nums.size() || nums[leftIdx] != target) {
        return range;
    }

    range[0] = leftIdx;
    range[1] = extremeInsertionIndex(nums, target, false)-1;

    return range;
}

int main() {
    vector<int> k;

    vector<int> temp1;
    k = searchRange(temp1, 0);
    for (int e : k){ cout<< e<< " ";}
    cout<<"\n";

    temp1.push_back(5);
    temp1.push_back(7);
    temp1.push_back(7);
    temp1.push_back(8);
    temp1.push_back(8);
    temp1.push_back(10);

    k = searchRange(temp1, 8);
    for (int e : k){ cout<< e<< " ";}
    cout<<"\n";

    vector<int> t2 {2,2};
    k = searchRange(t2, 1);
    for (int e : k){ cout<< e<< " ";}
    cout<<"\n";
    return 0;
}
