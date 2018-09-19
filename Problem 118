// 118. Pascal's Triangle. Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

#include <iostream>
#include <vector>
using namespace std;


vector<vector<int>> paskaltriangle(int numRows)
{
    vector<vector<int>> v;
    if (numRows == 0){ return v; }
    vector<int> v1 (1, 1);

    v.push_back(v1);
    if (numRows == 1) { return v; }

    v1.push_back(1);
    v.push_back(v1);
    if (numRows == 2) { return v; }

    vector<int> v0 (1, 1);
    for (int i = 2; i < numRows; i++){
        v1 = v0;
        for (int j = 1; j < i; j++) {
            v1.push_back(v[i-1][j-1]+v[i-1][j]);
        }
        v1.push_back(1);
        v.push_back(v1);
    }
    return v;
};

void printV (vector<vector<int>>& v, int n){
    for (int i = 0; i < n; i++){
        for (int j = 0; j <= i; j++) {
            cout << v[i][j]<< " ";
        }
        cout << endl;
    }
}
int main() {
    int n = 5;
    vector<vector<int>> k;
    k = paskaltriangle(n);
    printV(k,n);
    return 0;
}
