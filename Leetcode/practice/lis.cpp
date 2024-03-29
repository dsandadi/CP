#include <bits/stdc++.h>
/**
Longest Increasing Subsequence problem - find the length of longest increasing
subsequence such that all the elements in subsequence are sorted in increasing order.
    subsequence is generated by removing zero or more elements 
in the array preserving the order of leftover elements.
============================================================
Example
{10, 11, 12, 8, 13, 7, 14}
ans = {10, 11, 12, 13, 14} = 5
*/
using namespace std;

int longest_increasing_subsequence(vector<int>& arr){
    vector<int> dp;
    for(int i = 0; i < arr.size(); ++i){
        if((dp.size() == 0) || dp.back() < arr[i])
            dp.push_back(arr[i]);
        else{
            auto it = upper_bound(dp.begin(), dp.end(), arr[i]);
            *it = arr[i];
        }
    }
    return dp.size();
}

int main(){
    vector<int> ip {10, 11, 12, 8, 13, 7, 14};
    vector<int> ip2 {3, 10, 2, 1, 20};
    vector<int> ip3 {3, 2};
    vector<int> ip4 {50, 3, 10, 7, 40, 80};

    cout << longest_increasing_subsequence(ip) << endl; // 5
    cout << longest_increasing_subsequence(ip2) << endl; // 3
    cout << longest_increasing_subsequence(ip3) << endl; // 1
    cout << longest_increasing_subsequence(ip4) << endl; // 4

    return 0;
}