//
// Created by DINESH on 12/12/2016.
//

#include<iostream>
using namespace std;
//void rotateRight(BSTNode* & );
//void roateLeft(BSTNode* &);
struct BSTNode
{
    string key;
    int BF;
    BSTNode *left,*right;
    BSTNode():left(nullptr),right(nullptr){}
};
class Tree
{
public:
    void insertNode(BSTNode * &t,string key)
    {
        insertAVL(t,key);
    }
    int insertAVL(BSTNode* &t,string key)
    {
        if(t==nullptr)
        {
            t=new BSTNode;
            t->key=key;
            t->BF=0;
            return 1;

        }
        else
        {
            if(t->key!=key)
            {
                if(t->key>key)
                {

                    int delta=insertAVL(t->left,key);
                    if(delta==0) return 0;
                    switch(t->BF)
                    {
                        case 1: t->BF =0 ;break;
                        case 0:t->BF=-1;break;
                        case -1:fixLeftImbalance(t,key);return 0;
                    }
                }
                else
                {
                    int delta=insertAVL(t->right,key);
                    if(delta==0) return 0;
                    switch(t->BF)
                    {
                        case 0: t->BF=1;break;
                        case -1: t->BF=0;break;
                        case 1:cout<<"CHANGE  \n";return 0;
                    }
                }
            }
            else return 0;
        }
    }
    void fixLeftImbalance(BSTNode* &t,string key)
    {
        BSTNode* child=t->left;
        if(child->BF!=t->BF)
        {
            int oldBF=child->right->BF;
            rotateLeft(t->left);
            rotateRight(t);
            t->BF=0;
            t->left->BF=0;t->right->BF=-1;
        }
        else
        {
            rotateRight(t);
            t->right->BF=t->BF=0;
        }
    }
    void rotateLeft(BSTNode * &t)
    {
        BSTNode* child=t->right;
        t->right=child->left;
        child->left=t;
        t=child;
    }
    void rotateRight(BSTNode* &t)
    {
        BSTNode* child=t->left;
        t->left=child->right;
        child->right=t;
        t=child;
    }
    void display(BSTNode* t)
    {if(t==nullptr){}
        else
        {
            display(t->left);
            cout<<"------------------------"<<endl;
            cout<<" key:  "<<t->key<<endl<<" BF :"<<t->BF<<endl;
            display(t->right);
        }
    }
};
int main()
{
    BSTNode *Test=nullptr;
    Tree dinesh;
    dinesh.insertNode(Test,"He");
    dinesh.insertNode(Test,"H");
    dinesh.insertNode(Test,"Li");
    dinesh.insertNode(Test,"Be");
    dinesh.insertNode(Test,"B");
    dinesh.insertNode(Test,"C");
    dinesh.display(Test);
}