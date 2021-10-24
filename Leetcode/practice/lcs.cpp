#include <bits/stdc++.h>
/**
 * Longest common subsequence between two strings.
 * subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * 
 */
using namespace std;

int longest_common_subsequence(string s1, string s2)
{
    vector<vector<int>> dp(s1.length(), vector<int>(s2.length(), 0));

    for (int i = 0; i < s1.length(); ++i)
    {
        for (int j = 0; j < s2.length(); ++j)
        {
            if (s1[i] == s2[j])
                dp[i][j] = max(dp[i][j], ((i > 0 && j > 0) ? dp[i - 1][j - 1] : 0) + 1);
            else
                dp[i][j] = max(dp[i][j], max(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0));
        }
    }
    return dp[s1.length() - 1][s2.length() - 1];
}

int main()
{
    string s1 = "AGGTAB";
    string s2 = "GXTXAYB";

    cout << longest_common_subsequence(s1, s2) << endl;
    return 0;
}
