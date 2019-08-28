//204. Count Primes - E
//Count the number of prime numbers less than a non-negative number, n.

#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <math.h>
using namespace std;

int getPrimes(int n){
    int i = 2;
    bool isPrime = true;
    vector<int> v;
    while (i < n){
        isPrime = true;
        for (int elem : v){
            if (double(elem) > 1 + sqrt(i)) {
                break;
            } else if (i % elem == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) v.push_back(i);
        i++;
    }
    return v.size();
}


int main() {

    cout << getPrimes(10);
    return 0;
}
