#ifndef DSU
#define DSU
class DSU{
    public:
    vector<int> parents;
    DSU( int n){
        parents = vector<int>(n);
        for(int i = 0; i < n; i++)
            parents[i] = i;
    }
    int _find(int ind){
        if(parents[ind] != ind)
            parents[ind] = _find(parents[ind]);
        return parents[ind];
    }
    void _union(int ind1, int ind2){
        int p1 = _find(ind1);
        int p2 = _find(ind2);
        if(p1 != p2){
            parents[p2] = p1;
        }
        return ;
    }
};
#endif