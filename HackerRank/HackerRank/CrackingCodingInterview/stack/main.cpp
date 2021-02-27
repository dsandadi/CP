#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;


char inverseBracket(char& c){
    switch(c)
    {
        case '(':return ')';
        case '[': return ']';
        case '{':return '}';
        default : return ' ';
    }

}



bool isOpenBracket(char c){

    return ((c=='[')||(c=='{')||(c=='('));

}
bool isCloseBracket(char c){

    return ((c==')')||(c =='}')||(c==']'));

}


bool is_balanced(string expression) {

    stack<char> expressionStack ;
    for (int i =0;i<expression.length();i++)
    {char c = expression.at(i);
        if(isOpenBracket(c)){
            expressionStack.push(c);
        }
        else if(isCloseBracket(c)){
            char top = expressionStack.top();
            //cout<<inverseBracket(top);
            //char a = top;
            //cout<<a;
            if(expressionStack.empty()) return false;

            if(inverseBracket(top) != c) return false;

            expressionStack.pop();
        }
    }

    return expressionStack.empty();



}


int main(){
    int t;
    cin >> t;
    for(int a0 = 0; a0 < t; a0++){
        string expression;
        cin >> expression;
        bool answer = is_balanced(expression);
        if(answer)
            cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}
