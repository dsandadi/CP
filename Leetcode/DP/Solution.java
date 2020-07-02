class Solution {
    DSU dsu;
    class DSU{
        int[] parents;
        int size;
        public DSU(int n){
            this.parents = new int[n];
            for(int i =0; i < parents.length; i++)
                parents[i] = i;
            size = n;
        }
        private int findParent(int child){
            if(parents[child] != child)
                parents[child] = findParent(parents[child]);
            return parents[child];
        }
        private void union(int c1, int c2){
            int p1 = findParent(c1);
            int p2 = findParent(c2);
            if(p1 != p2){
                parents[p2] = p1;
                size--;                
                System.out.println(c1 + " :: " + c2 + " ==> " + size);
            }
            return ;
        }
        private boolean same(int n1, int n2){
            return findParent(n1) == findParent(n2);
        }
    }
    private int kruskalAlgo(int[][] edges, List<Integer> accepted, int n){
        DSU dsu = new DSU(n);
        int wt = 0;
        
        if(accepted.size() > 0){
            int[] edge = edges[accepted.get(0)];
            dsu.union(edge[0], edge[1]);
            wt += edge[2];
        }
        for(int i = 0; i < edges.length; i++){
            if(edges[i][0] == -1) {
                dsu.size--;
                continue;
            }
            if(!dsu.same(edges[i][0], edges[i][1])){
                dsu.union(edges[i][0], edges[i][1]);
                wt += edges[i][2];                
            }
        }
        
        return dsu.size > 1? Integer.MAX_VALUE: wt;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        
        List<Integer> critical = new ArrayList<>();
        List<Integer> non_critical = new ArrayList<>();
        List<Integer> accepted = new ArrayList<>();

        int wt = kruskalAlgo(edges, accepted, n);

        for(int i = 0; i < edges.length; i++){
            int temp = edges[i][0];
            edges[i][0] = -1;
            if(kruskalAlgo(edges, accepted, n) > wt)
                critical.add(i);
            else
                non_critical.add(i);
            edges[i][0] = temp;
        }
        System.out.println("done");

        List<Integer> pseudo_critical = new ArrayList<>();
        for(int i = 0; i < non_critical.size(); i++){
            accepted.add(non_critical.get(i));
            if(kruskalAlgo(edges, accepted, n) == wt){
                pseudo_critical.add(non_critical.get(i));
            }
            accepted.remove(accepted.size() - 1);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo_critical);
        return ans;
    }
}