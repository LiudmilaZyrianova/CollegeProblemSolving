//350. Intersection of Two Arrays II - E. Given two arrays, write a function to compute their intersection.

#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>
using namespace std;

void print(vector<int> nums1 ) {
    for (int e : nums1){
        cout << e << " ";
    }
    cout << "\n";
}

//HashMap Solution
//vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
//    unordered_map<int, int> dict;
//    vector<int> res;
//    for(int i = 0; i < (int)nums1.size(); i++) dict[nums1[i]]++;
//    for(int i = 0; i < (int)nums2.size(); i++)
//        if(--dict[nums2[i]] >= 0) res.push_back(nums2[i]);
//    return res;
//}

vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    vector<int> res;
    sort(nums1.begin(), nums1.end());
    sort(nums2.begin(), nums2.end());
    unsigned long p1 = 0;
    unsigned long p2 = 0;
    unsigned long s1 = nums1.size();
    unsigned long s2 = nums2.size();
    int a1; int a2;
    while (p1 < s1 && p2 < s2){
        a1 = nums1[p1]; a2 = nums2[p2];
        if (a1 < a2) {
            p1++;
        } else if (a1 > a2) {
            p2++;
        } else {
            res.push_back(nums1[p1]);
            p1++;
            p2++;
        }
    }
    return res;

}


int main() {
    vector<int> nums1 {1,2,2,1};
    vector<int> nums2 {2,2};
    print(intersect(nums1, nums2));
    vector<int> nums12 {4,9,5};
    vector<int> nums22 {9,4,9,8,4};
    print(intersect(nums12, nums22));
    return 0;
}
