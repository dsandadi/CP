class Trie {
public:
    Trie* nbrs[26] = {};
	bool end = false;
    /** Initialize your data structure here. */
    Trie() {
        
    }
    //insert word in to Trie.
    void insert(string word, int pos = 0){
		if(pos == word.size()){
            end = true;
            return ;    
        }
		auto idx = word[pos] - 'a';
		if(nbrs[idx] == nullptr)	nbrs[idx] = new Trie();
		nbrs[idx] -> insert(word, pos + 1);
	}
    // search
	bool search(string word, int pos = 0){
		if(pos == word.size()) return end;
		int idx = word[pos] - 'a';
        if(nbrs[idx] == nullptr) return false; 
		return nbrs[idx] -> search(word, pos + 1);
	}
   
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix, int pos = 0) {
        if(pos == prefix.size()) return true;
        auto idx = prefix[pos] - 'a';
        if(nbrs[idx] == nullptr) return false;
        return nbrs[idx]->startsWith(prefix, pos + 1);
    }
};