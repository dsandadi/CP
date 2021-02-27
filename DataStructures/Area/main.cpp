#include <iostream>
#include<stack>
using namespace std;
int MaxArea(int[]);
int FindArea(stack<int>);
int main() {
    int a;
    int in[6];
    cout<<"Enter the input"<<endl;
    for(int i=0;i<6;i++) {
        cin >> in[i];
    }
  //  cout<<"came here"<<endl;
    a=MaxArea(in);
    cout<<"Max Area is"<<a<<endl;
    return 0;
}
int MaxArea(int find[])
{
    stack<int> graph;
    int j=0;
    int area=0;
    int MaxArea=-1;
    for(int i=0;i<6;i++) cout<<find[i]<<endl;
    graph.push(0);
    //cout<<"pushed :"<<find[0]<<endl;
    int bar_number=1;

    for(int i=1;i<6;i++) {
        //int bar_number = 0;
        //bar_number++;
        while (find[i] < find[graph.top()]&&!(graph.empty())) {
            area = find[graph.top()] * (bar_number-graph.top());
    //        cout<<"in the pop:"<<endl<<graph.top()<<endl;
            graph.pop();
            if (area > MaxArea) MaxArea = area;
            //  cout<<"I can't come out"<<endl;
        //bar_number--;
        }
        graph.push(i);
        //cout<<"In the infinite loop"<<endl;
    ++bar_number;
    }
   // int bar_number=count;
    while(!graph.empty())
    {
        int area=find[graph.top()]*(bar_number-graph.top());
        graph.pop();
        if(area>MaxArea) MaxArea=area;
    }
    return MaxArea;
}
