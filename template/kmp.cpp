/*
Author: Dinesh Reddy Sandadi
*/
#include <bits/stdc++.h>
#define ll long long

using namespace std;
vector<int> kmp_table(string s){
    vector<int> kmp(s.length(), 0);
    int p1 = 0;
    for(int p2 = 1; p2 < s.length(); p2++){
        int j = kmp[p2 - 1];
        while(j > 0 && s[p2] != s[j])
            j = kmp[j - 1];
        if(s[p2] == s[j])
            ++j;
        kmp[p2] = j;
    }
    return kmp;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    while(T--){
    
    }
}