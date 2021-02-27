#include <iostream>
using namespace std;
int main() {
    int size;
    cin>>size;
    int data[size];
    cout<<"Enter the elements"<<endl;
    for(int i=0;i<size;i++)
    {
        cin>>data[i];
    }
    for(int i=0;i<size;i++)
    {
        for(int j=i+1;j<size;j++)
        {
            if(data[j]<data[i]) {
                int temp =data[i];
                data[i]=data[j];
                data[j]=temp;
            }
        }
    }
    for(int i=0;i<size;i++)
        cout << data[i] << endl;

        return 0;
}