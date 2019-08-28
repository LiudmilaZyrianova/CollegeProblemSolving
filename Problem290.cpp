//290. Word Pattern - E. Given a pattern and a string str, find if str follows the same pattern.
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <bits/stdc++.h>
#include <unordered_map>
#include <utility>
using namespace std;

vector<string> removeDupWord(string str)
{
    vector<string> res;
    string word = "";
    for (auto x : str)
    {
        if (x == ' ')
        {
            res.push_back(word);
            word = "";
        }
        else
        {
            word = word + x;
        }
    }
    res.push_back(word);
    return res;
}


bool wordPattern(string pattern, string str) {
    if (pattern.empty() && str.empty()){
        return true;
    } else if ((pattern.empty() && !str.empty()) || (!pattern.empty() && str.empty())) {
        return false;
    }
    vector<string> res = removeDupWord(str);
    if (pattern.size() != res.size()) return false;
    unordered_map<char, string> relation;
    for (int i = 0; i < pattern.size(); i++){
        if (relation.find(pattern[i]) == relation.end()){
            for ( pair<char, string>  elem : relation){
                if (res[i] == elem.second){
                    return false;
                }
            }
            relation.insert(make_pair(pattern[i], res[i]));
        } else if (relation.at(pattern[i]) != res[i]){
            return false;
        }
    }
    return true;
}

int main() {
    cout<< wordPattern("abba", "dog cat cat dog") << "\n";
    cout<< wordPattern("abba", "dog cat cat fish") << "\n";
    cout<< wordPattern("aaaa", "dog cat cat dog") << "\n";
    cout<< wordPattern("aaaa", "dog dog dog dog") << "\n";
    cout<< wordPattern("abba", "dog dog dog dog") << "\n";
    return 0;
}
