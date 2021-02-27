#include <iostream>
#include<map>
using namespace std;
struct Node
{
    string data;
    Node* parent;
    int Rank;
};
class DisJoint
{
public:  void MakeSet(string data);
    void Union(string data1,string data2);
    Node* FindSet(string data);
    map<string,Node* > Table;
};
void DisJoint:: MakeSet(string data)
{
    Node * n1=new Node();
    n1->data=data;
    n1->parent=n1;
    n1->Rank=1;
    Table[data]=n1;
}
void DisJoint::Union(string data1,string data2)
{
    Node * node1 = Table[data1];
    Node *node2=Table[data2];
    Node * parent1=FindSet(data1);
    Node* parent2=FindSet(data2);
    if(parent1->data==parent2->data)  return ;
    if(parent1->Rank>=parent2->Rank)
    {
        parent1->Rank=(parent1->Rank==parent2->Rank)? parent1->Rank+1:parent1->Rank;
        parent2->parent=parent1;
    }
    else {
        parent1->parent=parent2;
    }
}
Node * DisJoint:: FindSet(string data)
{
    Node * node1=Table[data];
  Node * parent=node1->parent
    while(parent->parent!=parent) {
            parent=parent->parent;
        }
    node1->parent=parent;
        return parent;
    }