//205. Isomorphic Strings - E. Given two strings s and t, determine if they are isomorphic.
// Two strings are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while 
// preserving the order of characters. No two characters may map to the same character but a character may map to itself.

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
#include <cmath>
using namespace std;

//Better solution:
//bool isIsomorphic(string s, string t) {
//    int m1[256] = {0}, m2[256] = {0}, n = s.size();
//    for (int i = 0; i < n; ++i) {
//        if (m1[s[i]] != m2[t[i]]) return false;
//        m1[s[i]] = i + 1;
//        m2[t[i]] = i + 1;
//    }
//    return true;
//}

bool isIsomorphic(string s, string t){
    unordered_map<char, char> mapFirstSecond;
    unordered_map<char, char> mapSecondFirst;
    //Assumed they have the same length
    //if (s.size() != t.size()) return false;
    for (int i = 0; i < s.size(); i++){
        auto resFS = mapFirstSecond.insert(make_pair(s[i], t[i]));
        auto resSF = mapSecondFirst.insert(make_pair(t[i], s[i]));
        if (!resFS.second){
            if (mapFirstSecond.at(s[i]) != (int) t[i])
                return false;
        }
        if (!resSF.second){
            if (mapSecondFirst.at(t[i]) != (int) s[i])
                return false;
        }
    }
    return true;
}

int main() {
    cout<< true<< endl;
    cout << isIsomorphic("egg", "dog") << endl;
    cout << isIsomorphic("ad", "aa") << endl;
    cout << isIsomorphic("egg", "TAa") << endl;
    cout << isIsomorphic("foo", "bar") << endl;

    cout << isIsomorphic("egg", "tAA") << endl;
    cout << isIsomorphic("egg", "add") << endl;
    cout << isIsomorphic("paper", "title") << endl;

    return 0;
}
