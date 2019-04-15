/*153. Find Minimum in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.*/

#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int Helper(const vector<int> &num, int l, int m, int r) //left, middle,right
{
    if ((m == l) || (m == r)){
        return min(num[l], min(num[m],num[r]));
    }

    else
    {
        int mid1 = (m+r)/2;
        int mid2 = (l+m)/2;
        if(num[m] > num[r])
            return Helper(num, m, mid1, r);
        else
            return Helper(num, l, mid2, m);
    }
};

//Binary Search
int findMin(const vector<int> &num) {
    return Helper(num, 0, (num.size()-1)/2, num.size()-1);
}


int main() {
    vector<int> v = {1,2};
    int i = findMin(v);
    cout << i << endl;
    return 0;
}
