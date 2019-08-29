//349. Intersection of Two Arrays -E. Given two arrays, write a function to compute their intersection.

#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

void print(vector<int>& nums1 ) {
    for (int e : nums1){
        cout << e << " ";
    }
    cout << "\n";
}

vector<int> intersection(vector<int>& nums1, vector<int>& nums2){
    vector<int> res;
    unordered_set<int> new_nums1;
    for (int e : nums1){
        if (new_nums1.find(e) == new_nums1.end()){
            new_nums1.insert(e);
        }
    }
    for (int e : nums2){
        if (new_nums1.find(e) != new_nums1.end()){
            res.push_back(e);
            new_nums1.erase(e);
        }
    }

    return res;
}

int main() {
    vector<int> nums1 {1,2,2,1};
    vector<int> nums2 {2,2};
    vector<int> nums3 = intersection(nums1, nums2);
    print(nums3);

    vector<int> nums12 {4,9,9,5};
    vector<int> nums22 {9,4,9,8,4};
    vector<int> nums32 = intersection(nums12, nums22);
    print(nums32);

    return 0;
}
