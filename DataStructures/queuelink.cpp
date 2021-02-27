<<<<<<< HEAD
#include<iostream>
using namespace std;
template<class T> class linQ<T>;
class Node
{ friend class linQ<T>;
	T data;
	Node<T> *next;
	public:Node(const T&x=T(),Node<T> *ptr=nullptr):data(x),next(ptr){}
};
template < class T>
class linQ
{
	Node<T> * front,*rear;
	public:linQ():front(nullptr),rear(nullptr){}
	bool empty() const;
	int size() const;
	bool enqueue(const T& x);
	bool dequeue();
	T peek() const; 
};
template <class T>
T linQ<T>::peek() const
{
	if(!empty())
	{
		return front->data;
	}
} 
template<class T>
bool linQ<T>::empty() const
{
	return front==rear;
}
template <class T>
int linQ<T> :: size() const
{
Node<T> *p=front;
int count =0;
	while(p!=nullptr)
	{
		count++;
		p=p->next;
	}
return count;
}
template<class T>
bool linQ<T> ::enqueue(const T&x)
{
	Node<T> *p=new Node<T> (x);
	if(empty()){
	front=rear=p;	
	}
	else
	{
	rear->next=p;
	rear=p;
	}
	return true;
}
template <class T>
bool linQ<T> ::dequeue()
{
	if(!empty())
	{
	Node<T> *p =front;
	front=front->next;
	delete p;	
	}
}

=======
#include<iostream>
using namespace std;
template<class T> class linQ<T>;
class Node
{ friend class linQ<T>;
	T data;
	Node<T> *next;
	public:Node(const T&x=T(),Node<T> *ptr=nullptr):data(x),next(ptr){}
};
template < class T>
class linQ
{
	Node<T> * front,*rear;
	public:linQ():front(nullptr),rear(nullptr){}
	bool empty() const;
	int size() const;
	bool enqueue(const T& x);
	bool dequeue();
	T peek() const; 
};
template <class T>
T linQ<T>::peek() const
{
	if(!empty())
	{
		return front->data;
	}
} 
template<class T>
bool linQ<T>::empty() const
{
	return front==rear;
}
template <class T>
int linQ<T> :: size() const
{
Node<T> *p=front;
int count =0;
	while(p!=nullptr)
	{
		count++;
		p=p->next;
	}
return count;
}
template<class T>
bool linQ<T> ::enqueue(const T&x)
{
	Node<T> *p=new Node<T> (x);
	if(empty()){
	front=rear=p;	
	}
	else
	{
	rear->next=p;
	rear=p;
	}
	return true;
}
template <class T>
bool linQ<T> ::dequeue()
{
	if(!empty())
	{
	Node<T> *p =front;
	front=front->next;
	delete p;	
	}
}

>>>>>>> d42305b39b923c4b9602289520b50b06a20c20e3
