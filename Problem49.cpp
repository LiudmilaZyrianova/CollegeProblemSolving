//49. Group Anagrams - M. Given an array of strings, group anagrams together.

#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <algorithm>
#include <cmath>
using namespace std;

void print(vector<vector<string>> v){
    for (auto el : v){
        for (const auto e : el){
            cout << e << " ";
        }
        cout << "\n";
    }
}

// Faster in Java
//public List<List<String>> groupAnagrams(String[] strs) {
//    if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
//    Map<String, List<String>> map = new HashMap<String, List<String>>();
//    for (String s : strs) {
//        char[] ca = s.toCharArray();
//        Arrays.sort(ca);
//        String keyStr = String.valueOf(ca);
//        if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
//        map.get(keyStr).add(s);
//    }
//    return new ArrayList<List<String>>(map.values());
//}
vector<vector<string>> groupAnagrams(vector<string>& strs) {
    vector<vector<string>> res;
    unordered_map<string, int> storage;
    const int start = 'a';
    for (const string elem : strs) {
        vector<int> count (26, 0);
        for (char e : elem){
            count[((int)e) - start]++;
        }
        string tempRes = "";
        for (int c : count){
            tempRes.append(to_string(c) + " ");
        }
        if (storage.find(tempRes) == storage.end()){
            vector<string> temp;
            temp.push_back(elem);
            res.push_back(temp);
            storage.insert(make_pair(tempRes, res.size()-1));
        } else {
            res[storage.at(tempRes)].push_back(elem);
        }
    }
    return res;

}

int main() {
    vector<string> v = {"eat", "tea", "tan", "ate", "nat", "bat"};
    print(groupAnagrams(v));
    return 0;
}
