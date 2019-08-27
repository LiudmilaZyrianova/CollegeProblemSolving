//216. Combination Sum III - M. Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//Note: All numbers will be positive integers. The solution set must not contain duplicate combinations.

#include <iostream>
#include <vector>
using namespace std;

void print(vector<vector<int>> v){
    for (vector<int> elem: v){
        for (int el: elem){
            cout << el << " ";
        }
        cout<< "\n";
    }
}

void makeCombination(vector<vector<int>>& res, vector<int> current, int startWith, int k, int n){
    if (k == 0 && n == 0){
        res.push_back(current);
        return;
    }
    else if (k > 0 && n > 0) {
        for (int i = startWith; i < 10; i++){
            if (n - i >= 0){
                current.push_back(i);
                makeCombination(res, current, i+1, k-1, n-i);
                current.pop_back();
            }
        }
    }
}

vector<vector<int>> combinationSum3(int k, int n) {
    vector<vector<int>> res;
    vector<int> current;
    if ( k >= 1 && n >= 1){
        makeCombination(res, current, 1, k, n);
    }
    return res;

}

int main() {
    print(combinationSum3(3, 7));
    cout<<"\n";
    print(combinationSum3(3, 9));

    return 0;
}
