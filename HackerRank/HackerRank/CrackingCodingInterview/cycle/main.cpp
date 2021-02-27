#include <iostream>
/*
Detect a cycle in a linked list. Note that the head pointer may be 'NULL' if the list is empty.

A Node is defined as:
    struct Node {
        int data;
        struct Node* next;
    }
*/
#include<vector>
#include<algorithm>

struct Node {
    int data;
    struct Node* next;
};
bool has_cycle(Node* head) {
    //std::set<Node*> visited ;
    std::vector<Node* > visited;
    while(head != nullptr)
    {
    if(find(visited.begin(),visited.end(),head) != visited.end()) return false;
        else visited.push_back(head);
        head = head->next;
    }



    // Complete this function
    // Do not write the main method
}

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}