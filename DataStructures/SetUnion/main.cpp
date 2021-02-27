#include <iostream>
#include<map>
using namespace std;
struct Node
{

    int data;
    int Rank;
    Node* parent;
};
class DisJointSet
{
public:
    map<int,Node*> Rep_Set;
    void MakeSet(int data);
    void Union(int data1,int data2);
    Node* FindSet(int data);
    void print();
};
void DisJointSet::MakeSet(int data)
{Node * n1=new Node();
    n1->data=data;
    n1->Rank=1;
    n1->parent=n1;
    Rep_Set[data]=n1;
}
void DisJointSet::Union(int data1,int data2)
{
    Node *node1=Rep_Set[data1];
    Node *node2=Rep_Set[data2];
    Node *parent1=FindSet(data1);
    Node* parent2=FindSet(data2);
    if(node1->data==node2->data ||parent1->data==parent2->data) return ;
    if(parent1->Rank>=parent2->Rank){
        parent1->Rank=(parent1->Rank==parent2->Rank)?parent1->Rank+1:parent1->Rank;
        parent2->parent=parent1;
    }
    else
    {
        parent1->parent=parent2;
    }
}
void DisJointSet::print()
{

}
Node* DisJointSet::FindSet(int data) {
{
    Node* node1=Rep_Set[data];
    Node * parent=node1->parent;
    if(parent==parent->parent) return parent;
    else
    {
        while(parent!=parent->parent)
        {
            parent=parent->parent;
        }
        node1->parent=parent;
        return parent;
    }}
}
int main()
{
    DisJointSet d1;
    d1.MakeSet(1);
    d1.MakeSet(2);
    d1.MakeSet(3);
    d1.MakeSet(4);
    d1.MakeSet(5);
    d1.MakeSet(6);
    d1.MakeSet(7);
    d1.Union(1,2);
    d1.Union(2,3);
    d1.Union(3,4);
    d1.Union(1,5);
    d1.Union(6,7);
    d1.Union(7,3);
    d1.print();
    cout<<d1.FindSet(1)<<endl<<d1.FindSet(2)<<endl<<d1.FindSet(3)<<endl<<d1.FindSet(7)<<endl;
}


