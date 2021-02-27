<<<<<<< HEAD
#include<iostream>
using namespace std;
template < class T>
struct Node<T>
{
	T data ;
	Node<T> *next;
	Node(const T & x=T(),Node <T> * ptr=nullptr):data(x),next(ptr){}
	
};
template <class T>
class linkedlist
{
	Node<T> *head;
	Node():head(nullptr){}
	void Add(const T &x)
	{Node<T> *n=new Node<T>(x);
		if(head==nullptr)
		head=n;
		else
		{Node<T> *p=head;
			while(p->next!=nullptr)
			{
				p=p->next;	
			}
			p->next=n;
		}	
	}
~linkedlist()
{ cout<<"I am in the destructor";
	while(head!=nullptr)
{
		cout<<"deleted"<<head->data<<endl;	
		Node<T> *p=head->next;
		delete head;
		head=p;
		
}
}};
int main()
{
	linkedlist a;
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	a.add(15);
}
=======
#include<iostream>
using namespace std;
template < class T>
struct Node<T>
{
	T data ;
	Node<T> *next;
	Node(const T & x=T(),Node <T> * ptr=nullptr):data(x),next(ptr){}
	
};
template <class T>
class linkedlist
{
	Node<T> *head;
	Node():head(nullptr){}
	void Add(const T &x)
	{Node<T> *n=new Node<T>(x);
		if(head==nullptr)
		head=n;
		else
		{Node<T> *p=head;
			while(p->next!=nullptr)
			{
				p=p->next;	
			}
			p->next=n;
		}	
	}
~linkedlist()
{ cout<<"I am in the destructor";
	while(head!=nullptr)
{
		cout<<"deleted"<<head->data<<endl;	
		Node<T> *p=head->next;
		delete head;
		head=p;
		
}
}};
int main()
{
	linkedlist a;
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	a.add(15);
}
>>>>>>> d42305b39b923c4b9602289520b50b06a20c20e3
