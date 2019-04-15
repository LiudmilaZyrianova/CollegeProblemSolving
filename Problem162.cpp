/*162. Find Peak Element
A peak element is an element that is greater than its neighbors.*/

#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int findPeakElement(vector<int>& nums) {
    int ind = -1;
    if (nums.size()>1){
        if (nums[0] > nums[1]) ind = 0;
        for (int i=1; i < nums.size()-1; i++){
            if ((nums[i] > nums[i-1])&&(nums[i] > nums[i+1])) {
                ind = i;
                break;
            }
        }
        if (nums[nums.size()-1] > nums[nums.size()-2]) ind = nums.size()-1;
    } else {
        ind = 0;
    }
    return ind;
}

//Binary Search
//int findPeakElement(const vector<int> &num) {
//    return Helper(num, 0, num.size()-1);
//}
//int Helper(const vector<int> &num, int low, int high)
//{
//    if(low == high)
//        return low;
//    else
//    {
//        int mid1 = (low+high)/2;
//        int mid2 = mid1+1;
//        if(num[mid1] > num[mid2])
//            return Helper(num, low, mid1);
//        else
//            return Helper(num, mid2, high);
//    }
//  }
//};

int main() {
    vector<int> v = {1,2,3,1};
    int i = findPeakElement(v);
    cout << i << endl;
//    for (int i = 0; i < v.size(); i++) {
//        cout<<v[i]<< " ";
//    }
    return 0;
}
