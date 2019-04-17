/*126. Word Ladder II
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord*/

#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
#include <deque>
#include <string>
using namespace std;


bool differInOne(string& s1, string& s2){
    int d = 0;
    for (int i = 0; i < s1.size(); i++){
        if (s1[i] != s2[i]) d++;
    }
    if (d == 1) return true;
    else return false;
};


void createRes(int indexOfBegin, string& beginWord, vector<string>& t,  vector<vector<string>>& res, vector<vector<int>>& parent,int index, vector<string>& wordList) {
    vector<string> temp;
    int currInd = index;
    for (int i = 0; i < parent[currInd].size(); i++) {
        vector<string> temp = {};
        for (int j = 0; j < t.size(); j++) { temp.push_back(t[j]);} //copy vector
        int p = parent[currInd][i];
        if (p != indexOfBegin) {
            temp.push_back(wordList[p]);
            createRes(indexOfBegin, beginWord, temp, res, parent, p, wordList);
        } else {
            temp.push_back(beginWord);
            res.push_back(temp);
        }

    }

}


vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
    vector<vector<string>> res;
    vector<bool> visited (wordList.size()+1, false);
    vector<int> level (wordList.size()+1, -1);
    vector<int> t;
    int indexOfBegin = wordList.size();
    for (int i=0; i<wordList.size(); i++) {
        if (wordList[i]==beginWord) indexOfBegin = i;
    }
    visited[indexOfBegin]=true;
    vector<vector<int>> parent (wordList.size(), t);        //every word has no parent yet
    deque<int> d;
    int p1 = indexOfBegin;
    d.push_back(p1);
    string tempStr; int tempInd;
    int currentLevel = -1;
    int endLevel = wordList.size();
    int indexOfEnd = 1;
    for (int i=0; i<wordList.size(); i++) {
        if (wordList[i]==endWord) indexOfEnd = i;
    }
    bool reachedEnd = false;
    vector<int> visitedHere = {};
    bool levelChanged = false;
    while ((d.size() != 0) && (currentLevel < endLevel)){
        tempInd = d.front();
        tempStr = (tempInd < wordList.size()) ? wordList[tempInd] : beginWord;
        d.pop_front();
        //if (levelChanged) { visitedHere.clear();}
        visitedHere.clear();
        for (int i = 0; i < wordList.size(); i++){
            if (differInOne(tempStr, wordList[i])) {
                if (wordList[i] == endWord) {
                    parent[i].push_back(tempInd);
                    endLevel = level[tempInd] + 1;
                    indexOfEnd = i;
                    reachedEnd = true;
                } else if (!visited[i]){
                    int p2 = i;
                    d.push_back(p2);
                    visitedHere.push_back(i);
                    parent[i].push_back(tempInd);
                    level[i] = level[tempInd] + 1 ;
                } else if ((visited[i])&&(level[i]==level[tempInd]+1)){
                    parent[i].push_back(tempInd);
                }
            }
        }

        if (d.size() != 0) {
            int newLevel = level[d.front()];
//            if (currentLevel != newLevel) {levelChanged = true;}
//            else {levelChanged = false;}
            currentLevel = newLevel;
        }
        //if (levelChanged){
            for (int i = 0; i < visitedHere.size(); i++){
                visited[visitedHere[i]]= true;
            }
        //}

    }

    //print(parent);
    if ((parent[indexOfEnd].size() == 0) || (!reachedEnd)) return res;
    else {
        vector<string> te {};
        createRes(indexOfBegin, beginWord, te, res, parent, indexOfEnd, wordList);
        for (int i = 0; i < res.size(); i++){
            reverse(res[i].begin(), res[i].end());
        }
        for (int i = 0; i < res.size(); i++){
            res[i].push_back(endWord);
        }
        return res;
    }
}

//OR
//vector<vector<string>> findLadders(string beginWord, string endWord, unordered_set<string> &wordList) {
//    //very interesting problem
//    //It can be solved with standard BFS. The tricky idea is doing BFS of paths instead of words!
//    //Then the queue becomes a queue of paths.
//    vector<vector<string>> ans;
//    queue<vector<string>> paths;
//    wordList.insert(endWord);
//    paths.push({beginWord});
//    int level = 1;
//    int minLevel = INT_MAX;
//
//    //"visited" records all the visited nodes on this level
//    //these words will never be visited again after this level
//    //and should be removed from wordList. This is guaranteed
//    // by the shortest path.
//    unordered_set<string> visited;
//
//    while (!paths.empty()) {
//        vector<string> path = paths.front();
//        paths.pop();
//        if (path.size() > level) {
//            //reach a new level
//            for (string w : visited) wordList.erase(w);
//            visited.clear();
//            if (path.size() > minLevel)
//                break;
//            else
//                level = path.size();
//        }
//        string last = path.back();
//        //find next words in wordList by changing
//        //each element from 'a' to 'z'
//        for (int i = 0; i < last.size(); ++i) {
//            string news = last;
//            for (char c = 'a'; c <= 'z'; ++c) {
//                news[i] = c;
//                if (wordList.find(news) != wordList.end()) {
//                    //next word is in wordList
//                    //append this word to path
//                    //path will be reused in the loop
//                    //so copy a new path
//                    vector<string> newpath = path;
//                    newpath.push_back(news);
//                    visited.insert(news);
//                    if (news == endWord) {
//                        minLevel = level;
//                        ans.push_back(newpath);
//                    }
//                    else
//                        paths.push(newpath);
//                }
//            }
//        }
//    }
//    return ans;
//}

int main() {
    string beginWord = "red";
    string endWord = "tax";
    vector<string> wordList = {"ted","tex","red","tax","tad","den","rex","pee"};
    vector<vector<string>> res = findLadders(beginWord, endWord, wordList);
    for (auto elem : res) {
        for (auto e : elem)
            cout<< e << " ";
        cout<<"\n";
    }
    return 0;
}
