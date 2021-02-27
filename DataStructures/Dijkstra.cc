<<<<<<< HEAD
#include <vector>
#include<iostream>
#include<string>
#include<set>
#include<map>
#include<queue>
using namespace std;
struct SimpleGraph;
struct Node;
struct Arc;
void printAdjacencyList(SimpleGraph& );

struct SimpleGraph
{
    set<Node *> nodes;
    set<Arc *> arcs;
    map<string , Node *> nodeMap;//naming the nodes
};
struct Node
{
    string name;
    set<Arc *> arcs;
};
struct Arc
{
    Node * start;
    Node * finish;
    double cost;
};
void printAdjacencyList(SimpleGraph& g)
{
    for(Node * node : g.nodes) {
        cout << node->name;
     //  bool flag =true;
        for (Arc *arc:node->arcs) {
            cout << ", ";
    cout<<arc->finish->name;
     //       Arc *a2;
   //         if (arc->finish->name == node->na
            //}
//if(flag)//
            //cout << arc->finish->name;
     //   else cout<<a2->finish->name;
       // flag=false;
        }

        cout << endl;
        //flag=true;
        }
}
void addNode(SimpleGraph & g,string state)
{
    Node * s=new Node();
    s->name=state;
    g.nodes.insert(s);
    g.nodeMap[state]=s;
}
void addArc(SimpleGraph & g,string start,string end,int cost)
{
    Arc *a1=new Arc();
    a1->start=g.nodeMap[start];
    a1->finish=g.nodeMap[end];
    a1->start->name=start;
    a1->cost=cost;
    a1->finish->name=end;
    g.arcs.insert(a1);
    g.nodeMap[start]->arcs.insert(a1);

}
void addFlight(SimpleGraph & g,string s1,string s2,int cost)
{
    addArc(g,s1,s2,cost);
    addArc(g,s2,s1,cost);
}
void initAirLineGraph(SimpleGraph & airline)
{
    addNode(airline,"Atlanta");
    addNode(airline,"Boston");
    addNode(airline,"Chicago");
    addNode(airline,"Dallas");
    addNode(airline,"Denver");
    addNode(airline,"Los Angeles");
    addNode(airline,"New York");
    addNode(airline,"Portland");
    addNode(airline,"San Fransico");
    addNode(airline,"Seattle");
    addFlight(airline,"Atlanta","Chicago",599);
    addFlight(airline,"Atlanta","Dallas",725);
    addFlight(airline,"Atlanta","New York",756);
    addFlight(airline,"Boston","New York",191);
    addFlight(airline,"Boston","Seattle",2489);
    addFlight(airline,"Chicago","Denver",907);
    addFlight(airline,"Dallas","Denver",650);
    addFlight(airline,"Dallas","Los Angeles",1240);
    addFlight(airline,"Dallas","San Fransico",1468);
    addFlight(airline,"Denver","San Fransico",954);
    addFlight(airline,"Portland","San Fransico",550);
    addFlight(airline,"Portland","Seattle",130);
}
void visit(Node * & node)
{
    cout<<"Visited :"<<node->name<<endl;
}
void visitBF(Node * & node)
{
    set<Node * > visited2;
    queue<Node * > nodes;
    //if(visited2.find(node)!=visited2.end()) return ;
     nodes.push(node);
    visit(node);
    visited2.insert(node);
    while(!nodes.empty())
     {     node=nodes.front();
         nodes.pop();
         //visited2.insert(node);
         for(Arc * arcs :node->arcs)
        {
            if(visited2.find(arcs->finish)==visited2.end()) {
                visit(arcs->finish);
                visited2.insert(arcs->finish);
                nodes.push(arcs->finish);
            }
            }
         //nodes.pop();
     //    visitBF(nodes.front());
     }
}

void visitDFT(Node * & node,set<Node * > & visited)
{
    if(visited.find(node)!=visited.end()) return;
    else
    {visit(node);
        for(Arc * arcs:node->arcs)
        {
            //visit(arcs->start);
            visited.insert(arcs->start);
            visitDFT(arcs->finish,visited);
        }
    }
}
void DFT(Node * node)
{
    set<Node *> visited;
    visitDFT(node,visited);}

struct mycomparision
{
    bool operator()(vector<Arc *> v1,vector<Arc *> v2) {
        double cost1=0,cost2=0;
        for(Arc * arcs:v1)
        {
            cost1+=arcs->cost;
        }
        for(Arc * arcs:v2)
        {
            cost2+= arcs->cost;
        }
        return (cost1>cost2);
    }
};

vector<Arc * > findShortestPath(Node *  begin,Node * & end)
{    vector<Arc * > path;
    map<string,double> fixed;
    double price=0;
    priority_queue <vector<Arc*>,vector<vector<Arc*>>,mycomparision> queue;
    while(begin!=end)
    {if(fixed.find(begin->name)==fixed.end()) {
            fixed[begin->name] = price;
        }
        for(Arc * arcs:begin->arcs)
        {
            if(fixed.find(arcs->finish->name)==fixed.end())
            {
                path.push_back(arcs);
                queue.push(path);
                path.erase(--path.end());
            }}
        if(queue.empty()) {
            path.clear();
            cout<<"queue is empty"<<endl;
            return path;}
        path=queue.top();
     //   for(Arc *temp:path)
       // {
         //   cout<<temp->finish->name<<"-->";
        //}
        //cout<<endl;
        begin=path.back()->finish;
        if(fixed.find(begin->name)==fixed.end())
        fixed[begin->name]=fixed[path.back()->start->name]+path.back()->cost;
        price=fixed[begin->name];
       // cout<<"cost in:"<<begin->name<<fixed[begin->name]<<endl<<"cost in: "<<path.back()->start->name<<fixed[path.back()->start->name]<<endl;
        queue.pop();
    }
    cout<<endl<<"Cost of "<<path.back()->finish->name<<"is :"<<fixed[path.back()->finish->name]<<endl;
    return path;
}



int main()
{
    SimpleGraph airline;
    initAirLineGraph(airline);
    printAdjacencyList(airline);
   // visitBF(airline.nodeMap["San Fransico"]);
    vector<Arc * > path;
    path=findShortestPath(airline.nodeMap["San Fransico"],airline.nodeMap["Boston"]);

    for(Arc *arcs :path)
    {
        cout<<arcs->start->name<<"-->";
    }
    cout<<"Boston"<<endl;

    return 0;
}//
// Created by DINESH on 12/16/2016.
//

=======
#include <vector>
#include<iostream>
#include<string>
#include<set>
#include<map>
#include<queue>
using namespace std;
struct SimpleGraph;
struct Node;
struct Arc;
void printAdjacencyList(SimpleGraph& );

struct SimpleGraph
{
    set<Node *> nodes;
    set<Arc *> arcs;
    map<string , Node *> nodeMap;//naming the nodes
};
struct Node
{
    string name;
    set<Arc *> arcs;
};
struct Arc
{
    Node * start;
    Node * finish;
    double cost;
};
void printAdjacencyList(SimpleGraph& g)
{
    for(Node * node : g.nodes) {
        cout << node->name;
     //  bool flag =true;
        for (Arc *arc:node->arcs) {
            cout << ", ";
    cout<<arc->finish->name;
     //       Arc *a2;
   //         if (arc->finish->name == node->na
            //}
//if(flag)//
            //cout << arc->finish->name;
     //   else cout<<a2->finish->name;
       // flag=false;
        }

        cout << endl;
        //flag=true;
        }
}
void addNode(SimpleGraph & g,string state)
{
    Node * s=new Node();
    s->name=state;
    g.nodes.insert(s);
    g.nodeMap[state]=s;
}
void addArc(SimpleGraph & g,string start,string end,int cost)
{
    Arc *a1=new Arc();
    a1->start=g.nodeMap[start];
    a1->finish=g.nodeMap[end];
    a1->start->name=start;
    a1->cost=cost;
    a1->finish->name=end;
    g.arcs.insert(a1);
    g.nodeMap[start]->arcs.insert(a1);

}
void addFlight(SimpleGraph & g,string s1,string s2,int cost)
{
    addArc(g,s1,s2,cost);
    addArc(g,s2,s1,cost);
}
void initAirLineGraph(SimpleGraph & airline)
{
    addNode(airline,"Atlanta");
    addNode(airline,"Boston");
    addNode(airline,"Chicago");
    addNode(airline,"Dallas");
    addNode(airline,"Denver");
    addNode(airline,"Los Angeles");
    addNode(airline,"New York");
    addNode(airline,"Portland");
    addNode(airline,"San Fransico");
    addNode(airline,"Seattle");
    addFlight(airline,"Atlanta","Chicago",599);
    addFlight(airline,"Atlanta","Dallas",725);
    addFlight(airline,"Atlanta","New York",756);
    addFlight(airline,"Boston","New York",191);
    addFlight(airline,"Boston","Seattle",2489);
    addFlight(airline,"Chicago","Denver",907);
    addFlight(airline,"Dallas","Denver",650);
    addFlight(airline,"Dallas","Los Angeles",1240);
    addFlight(airline,"Dallas","San Fransico",1468);
    addFlight(airline,"Denver","San Fransico",954);
    addFlight(airline,"Portland","San Fransico",550);
    addFlight(airline,"Portland","Seattle",130);
}
void visit(Node * & node)
{
    cout<<"Visited :"<<node->name<<endl;
}
void visitBF(Node * & node)
{
    set<Node * > visited2;
    queue<Node * > nodes;
    //if(visited2.find(node)!=visited2.end()) return ;
     nodes.push(node);
    visit(node);
    visited2.insert(node);
    while(!nodes.empty())
     {     node=nodes.front();
         nodes.pop();
         //visited2.insert(node);
         for(Arc * arcs :node->arcs)
        {
            if(visited2.find(arcs->finish)==visited2.end()) {
                visit(arcs->finish);
                visited2.insert(arcs->finish);
                nodes.push(arcs->finish);
            }
            }
         //nodes.pop();
     //    visitBF(nodes.front());
     }
}

void visitDFT(Node * & node,set<Node * > & visited)
{
    if(visited.find(node)!=visited.end()) return;
    else
    {visit(node);
        for(Arc * arcs:node->arcs)
        {
            //visit(arcs->start);
            visited.insert(arcs->start);
            visitDFT(arcs->finish,visited);
        }
    }
}
void DFT(Node * node)
{
    set<Node *> visited;
    visitDFT(node,visited);}

struct mycomparision
{
    bool operator()(vector<Arc *> v1,vector<Arc *> v2) {
        double cost1=0,cost2=0;
        for(Arc * arcs:v1)
        {
            cost1+=arcs->cost;
        }
        for(Arc * arcs:v2)
        {
            cost2+= arcs->cost;
        }
        return (cost1>cost2);
    }
};

vector<Arc * > findShortestPath(Node *  begin,Node * & end)
{    vector<Arc * > path;
    map<string,double> fixed;
    double price=0;
    priority_queue <vector<Arc*>,vector<vector<Arc*>>,mycomparision> queue;
    while(begin!=end)
    {if(fixed.find(begin->name)==fixed.end()) {
            fixed[begin->name] = price;
        }
        for(Arc * arcs:begin->arcs)
        {
            if(fixed.find(arcs->finish->name)==fixed.end())
            {
                path.push_back(arcs);
                queue.push(path);
                path.erase(--path.end());
            }}
        if(queue.empty()) {
            path.clear();
            cout<<"queue is empty"<<endl;
            return path;}
        path=queue.top();
     //   for(Arc *temp:path)
       // {
         //   cout<<temp->finish->name<<"-->";
        //}
        //cout<<endl;
        begin=path.back()->finish;
        if(fixed.find(begin->name)==fixed.end())
        fixed[begin->name]=fixed[path.back()->start->name]+path.back()->cost;
        price=fixed[begin->name];
       // cout<<"cost in:"<<begin->name<<fixed[begin->name]<<endl<<"cost in: "<<path.back()->start->name<<fixed[path.back()->start->name]<<endl;
        queue.pop();
    }
    cout<<endl<<"Cost of "<<path.back()->finish->name<<"is :"<<fixed[path.back()->finish->name]<<endl;
    return path;
}



int main()
{
    SimpleGraph airline;
    initAirLineGraph(airline);
    printAdjacencyList(airline);
   // visitBF(airline.nodeMap["San Fransico"]);
    vector<Arc * > path;
    path=findShortestPath(airline.nodeMap["San Fransico"],airline.nodeMap["Boston"]);

    for(Arc *arcs :path)
    {
        cout<<arcs->start->name<<"-->";
    }
    cout<<"Boston"<<endl;

    return 0;
}//
// Created by DINESH on 12/16/2016.
//

>>>>>>> d42305b39b923c4b9602289520b50b06a20c20e3
