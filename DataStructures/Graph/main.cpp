#include<iostream>
#include<string>
#include<set>
#include<map>
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
void depthFirstSearch(Node * node)
{
set<Node * > visited;
    visitUsingDF(node,visited);
}
void visitUsingDF(Node * node,set<Node * > &visited)
{
    if(visited.)
}
void printAdjacencyList(SimpleGraph& g)
{
    for(Node * node : g.nodes)
    {
        cout<<node->name;
        bool first=true;
        for(Arc *arc:node->arcs)
        {	if(!first) cout<<", ";
            cout<<arc->finish->name;
        }
        cout<<endl;
    }
}
void addNode(SimpleGraph & g,string state)
{
    Node * s=new Node();
    s->name=state;
    g.nodes.insert(s);
    g.nodeMap[state]=s;
}
void addFlight(SimpleGraph & g,string s1,string s2,int cost)
{
    Arc * arc=new Arc();
    arc->cost=cost;
    arc->start=g.nodeMap[s1];
    arc->finish=g.nodeMap[s2];
    g.arcs.insert(arc);
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
    addNode(airline,"San Francisco");
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
int main()
{
    SimpleGraph airline;
    initAirLineGraph(airline);
    printAdjacencyList(airline);
    return 0;

}//
// Created by DINESH on 12/16/2016.
//

