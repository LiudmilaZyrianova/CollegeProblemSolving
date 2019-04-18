/*122. Best Time to Buy and Sell Stock II - E
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (i.e., buy one and sell one share of the stock multiple times).
*/

#include <iostream>
#include <iostream>
#include <algorithm>
#include <vector>
#include <deque>
#include <string>
using namespace std;

int maxProfit(vector<int>& prices) {
    int total = 0;
    int bottom = 0;
    int peak = 0;
    bool stop = false;
    int i = 1;
    while (!stop){
        while ((i<prices.size()) && (prices[i] <= prices[i-1])){
            bottom = i;
            i++;
        }
        while ((i<prices.size()) && (prices[i] >= prices[i-1])){
            peak = i;
            i++;
        }
        if (peak <= bottom) stop = true;
        if (peak > bottom) {
            total = total + (prices[peak] - prices[bottom]);
            peak = 0;
            bottom = 0;
        }
    }
    return total;
}

// Another solution in Java: we can simply go on crawling over the slope and keep on adding the profit obtained from every consecutive transaction
// public int maxProfit(int[] prices) {
//    int maxprofit = 0;
//    for (int i = 1; i < prices.length; i++) {
//        if (prices[i] > prices[i - 1])
//            maxprofit += prices[i] - prices[i - 1];
//    }
//    return maxprofit;
//}

int main() {
    vector<int> nums = {7,5,3};
    int res = maxProfit(nums);  //0
    cout<< res<<"\n";
    return 0;
}
