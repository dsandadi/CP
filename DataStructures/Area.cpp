<<<<<<< HEAD
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
    cout<<"came here"<<endl;
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
    graph.push(find[0]);
    //cout<<"pushed :"<<find[0]<<endl;
    for(int i=1;i<6;i++) {
        int bar_number = 0;
        while (find[i] < graph.top()&&!(graph.empty())) {
            area = graph.top() * (++bar_number);
        cout<<"in the pop:"<<endl<<graph.top()<<endl;
		    graph.pop();
            if (area > MaxArea) MaxArea = area;
      //  cout<<"I can't come out"<<endl;
		}
      graph.push(i);
    //cout<<"In the infinite loop"<<endl;
    }
    int bar_number=0;
    while(!graph.empty())
    {
        int area=graph.top()*(++bar_number);
        graph.pop();
        if(area>MaxArea) MaxArea=area;
    }
return MaxArea;
}

=======
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
    cout<<"came here"<<endl;
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
    graph.push(find[0]);
    //cout<<"pushed :"<<find[0]<<endl;
    for(int i=1;i<6;i++) {
        int bar_number = 0;
        while (find[i] < graph.top()&&!(graph.empty())) {
            area = graph.top() * (++bar_number);
        cout<<"in the pop:"<<endl<<graph.top()<<endl;
		    graph.pop();
            if (area > MaxArea) MaxArea = area;
      //  cout<<"I can't come out"<<endl;
		}
      graph.push(i);
    //cout<<"In the infinite loop"<<endl;
    }
    int bar_number=0;
    while(!graph.empty())
    {
        int area=graph.top()*(++bar_number);
        graph.pop();
        if(area>MaxArea) MaxArea=area;
    }
return MaxArea;
}

>>>>>>> d42305b39b923c4b9602289520b50b06a20c20e3
