#include <iostream>
#include <vector>
#include <iterator>
using namespace std`

void merge (vector<int>& num1, vector<int>& num2, int n, int m){
    while (num1.size() > n) {
        num1.pop_back();
    }
    while (num2.size() > m) {
        num2.pop_back();
    }
    vector<int>::iterator it= num2.begin();
    int j=0;
    for (int i=0; i<n; i++){
        while (j<n+m){
            if (j >= m+i){
                num2.insert(it, num1[i]);
                it = num2.begin();
                j=j+1;
                it = next(it, j);
                break;
            } else {
                if (num1[i]<=num2[j]){
                    num2.insert(it, num1[i]);
                    it = num2.begin();
                    j=j+1;
                    it = next(it, j);
                    break;
                } else {
                    it = num2.begin();
                    j=j+1;
                    it = next(it,j);
                }
            }
        }
    }
}
int main() {
    std::cout << "Hello, World!" << std::endl;
    int n = 1;
    int m = 0;
    vector<int> num1 = {1};
    vector<int> num2 = {};


    merge (num1, num2,  n,  m);
    for (int i=0; i<num2.size(); i++){
        cout << num2[i]<< endl;
    }
    return 0;
}
