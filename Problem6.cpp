//6. ZigZag Conversion - M. The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
// (you may want to display this pattern in a fixed font for better legibility)
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//Write the code that will take a string and make this conversion given a number of rows.

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
#include <cmath>
#include <assert.h>

using namespace std;

string convert(string s, int numRows) {
    if (numRows <= 1) return s;
    long n = s.size();
    int mod = 2*numRows - 2;
    vector<char> temp;
    vector<vector<char>> v (numRows, temp);
    for (int i = 0; i < n; i++) {
        int tempMod = i%mod;
        if (tempMod < numRows) {
            v[tempMod].push_back(s[i]);
        } else {
            v[mod - tempMod].push_back(s[i]);
        }
    }
    string res;
    for (auto elem : v) {
        for (char e : elem) {
            res.append(1,e);
        }
    }
    return res;

}

int main() {
    cout << convert("PAYPALISHIRING", 3) << endl;
    assert(convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR");
    cout << convert("PAYPALISHIRING", 4) << endl;
    assert(convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI");

    return 0;
}
