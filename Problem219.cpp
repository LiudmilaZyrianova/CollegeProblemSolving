//219. Contains Duplicate II - E. Given an array of integers and an integer k, 
// find out whether there are two distinct indices i and j in the array such that 
// nums[i] = nums[j] and the absolute difference between i and j is at most k.

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
#include <cmath>
using namespace std;

bool hasDuplicates(vector<int>& nums, int k){
    if (k == 0) return false;
    unordered_set<int> hashSet;
    int n = nums.size();
    for (int i = 0; i < n; i++){
        if (hashSet.find(nums[i]) != hashSet.end()){
            return true;
        } else {
            if (i >= k) {
                hashSet.erase(nums[i-k]);
            }
            hashSet.insert(nums[i]);
        }
    }
    return false;
}

int main() {
    vector<int> v1 {1,2,3,1,2,3};
    cout << hasDuplicates(v1, 2) << endl;
    cout << hasDuplicates(v1, 3) << endl;
    cout << hasDuplicates(v1, 4) << endl;
    cout << hasDuplicates(v1, 5);
    vector<int> v2 {1,2,1};
    cout << hasDuplicates(v2, 0) << endl;
    return 0;
}
