#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include<map>
using namespace std;

int solution(int N,vector<int> M,map<int,int>& Vault)
{int ways=0;
    if(N==0) return 1;
        if(N<0) return 0;
    else
    { bool Have_Change=false;
        int i;
        for(i=0;i<M.size();i++)
        {cout<<"Entered"<<endl;

            if(Vault.find(N-M[i])!=Vault.end()) {
                if(N-M[i]==M[i]) { cout<<"In the right loop"<<endl;++ways;continue;}
            }
             else{ cout<<"N is"<<N<<"ways : "<<ways<<endl<<"called "<<N-M[i]<<endl;
                ways+=solution(N-M[i],M,Vault);}
        }
      Vault[N]=ways;
        return Vault[N];
}}
int main() {
    int N;
    cin>>N;
    int size;
    cin>>size;
    vector<int> M (size,0);
   for(int i=0;i<M.size();i++)
   {
       cin>>M[i];
   }


    map<int,int> Vault;
    cout<<solution(N,M,Vault)<<endl;
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    return 0;
}
