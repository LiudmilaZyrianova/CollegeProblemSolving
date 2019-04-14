// 66.Plus One. Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

#include <iostream>
#include <vector>
using namespace std;


vector<int> plusOne(vector<int>& digits) {
    int n = digits.size();
    bool mark = true;
    while (mark == true){
        if (n == 0){
            digits.insert(digits.begin(), 1);
            mark = false;
        } else {
            if (digits[n-1]<9){
                digits[n-1]++;
                mark = false;
            } else {
                digits[n-1]=0;
                n--;
            }
        }

    }
    return digits;
}

void printV (vector<int>& v, int n){
    for (int i = 0; i < n; i++){
        cout << v[i]<< " ";
    }
}
int main() {
    vector<int> k;
    vector<int> digits;
    digits.push_back(9);
    digits.push_back(9);
    digits.push_back(9);
    k = plusOne(digits);
    printV(k,k.size());
    return 0;
}
