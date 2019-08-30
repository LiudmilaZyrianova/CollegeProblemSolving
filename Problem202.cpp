//202. Happy Number - E. Write an algorithm to determine if a number is "happy".
//A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
#include <cmath>
using namespace std;

bool isHappy(int n) {
    unordered_set<int> set;
    while (true){
        int res = 0;
        while (n > 0){
            res = res + (n%10)*(n%10);
            n = n/10;
        }
        n = res;
        if (n == 1) return true;
        if (set.find(n) != set.end()) return false;
        else set.insert(n);
    }
}


int main() {
    cout << isHappy(19) << endl;
    cout << isHappy(18) << endl;
    return 0;
}
