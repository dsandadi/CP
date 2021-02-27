#include <iostream>
#include<cassert>
using namespace std;
template <class T>
struct Node
{
    T data;
    Node<T>* next;
    Node(const T& =T(),Node< T >* =nullptr);
};
template <class T>
Node <T> ::Node(const T& x,Node<T > *ptr):data(x),next(ptr){}
template <class T>
class stackInt
{
public:
//	 virtual bool empty() const =0;
    virtual bool pop() =0;
    virtual bool push(const T &x) =0;
    virtual T peek() const=0;
};
template <class T>
class linStack: public stackInt<T>
{
    Node<T> * top;
public:linStack():top(nullptr){}
    linStack(const linStack& s)
    {cout<< "COYING DATA ..."<<endl;
        if(s.top==nullptr)
            top =nullptr;
        else
        {	//Node<T> *p = new Node <T> ( );
            top=new Node<T>(s.top->data);
            Node< T>* p=s.top;
            Node <T>* q = top;

            while(p->next!=nullptr)
            {  p=p->next;
                q->next=new Node<T>();
                q=q->next;
                q->data=p -> data ;
                //p=p->next;
                //	q=q->next;
            }
        }
    }
    bool push(const T &x )
    {
        Node< T > * p=new Node<T> (x);
        p->next=top;
        top =p;
        return 1;
    }
    bool pop()
    {
        if(top==nullptr) return false;
        Node <T> *p=top;
        top=top->next;
        delete[] p;
        p=nullptr;
        return true;
    }
    T peek() const
    {
        assert(top!=nullptr);
        return top->data;
    }
    bool insert(const T& x,int pos)
    {int count=0;
        Node<T> *p=top;
        while(count<pos)
        {
            p=p->next;
            count++;
        }
        return true;
    }
    void print()
    {
        Node<T> * p=top;
        while(p!=nullptr)
        {
            cout<<"Data : "<<p->data<<endl;
            p=p->next;
        }
    }
};

int main()
{
    linStack<int> l1;
    l1.push(20);
    l1.push(30);
    l1.push(40);
    l1.push(50);
    l1.push(60);
    l1.print();
    linStack <int > l2(l1);
    l2.print();
    return 0;
}