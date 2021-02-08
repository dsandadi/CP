#include<bits/stdc++.h>
const int ALPHABETS_SIZE = 26;
class Trie{
	shared_ptr<Trie> nbrs[ALPHABETS_SIZE];
	bool end = false;
	public: 
		Trie(){
			end = false;
		}
		void insertWord(string word){
			shared_ptr<Trie> curr(this);
			for(int i = 0; i < word.size(); i++){
				int dig = word[i] - 'a';
				if(curr->nbrs[dig] == nullptr)
					curr -> nbrs[dig] = shared_ptr<Trie>(new Trie());
				curr = curr -> nbrs[dig];
			}
			return ;
		}
		bool startsWith(string prefix){
			shared_ptr<Trie> curr(this);
			for (int i = 0; i < prefix.size(); ++i)
			{
				int dig = prefix[i] - 'a';
				if(curr->nbrs[dig] == nullptr) return false;
				curr = curr -> nbrs[dig];
			}
			return true;
		}
};
int main(){

}