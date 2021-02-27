#include<iostream>
#include<algorithm>
#include<array>
using namespace std;


int createAnswer(int costs[],int length){
	int amount = costs[0] ;
	int discount = amount;
	for(int i = 1;i<length;i++){
		int a = costs[i]-discount;
		if( a < 0)  a = 0;
		
		amount += a;
		
		discount = min(discount,costs[i]);
		
	}
	
	return amount;
}
int main()
{	int N;
	cout<<"Enter Numbers"<<"\n";
	cin>>N;
	int a[N];
	for(int i = 0;i<N;i++){
		cin>>a[i];
	}	
	cout<<"\n Amount :"<<createAnswer(a,N);
	
}

