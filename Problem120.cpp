// 120. Triangle - M. Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int minimumTotal(vector<vector<int>>& triangle) {
    int n = triangle.size();
    vector<int> res (n, 0);
    vector<int> temp (n, 0);

    res[0] = triangle[0][0];
    for ( int i = 1; i < n; i++ ){
        temp[0] = triangle[i][0] + res[0];
        for (int j = 1; j < i; j ++) {
            temp[j] = min(res[j-1], res[j]) + triangle[i][j];
        }
        temp[i] = res[i-1] + triangle[i][i];
        res = temp;
    }

    return *min_element(res.begin(), res.end());
}

int main() {
    int k;
    vector<vector<int>> triangle;

    vector<int> temp1;
    temp1.push_back(2);
    triangle.push_back(temp1);

    vector<int> temp2;
    temp2.push_back(3); temp2.push_back(4);
    triangle.push_back(temp2);

    vector<int> temp3;
    temp3.push_back(6); temp3.push_back(5); temp3.push_back(7);
    triangle.push_back(temp3);

    vector<int> temp4;
    temp4.push_back(4); temp4.push_back(1); temp4.push_back(8); temp4.push_back(3);
    triangle.push_back(temp4);

    k = minimumTotal(triangle);
    cout << k<< endl;

    return 0;
}
