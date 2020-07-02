import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
                continue;
            }
            if(!dsu.same(edges[i][0], edges[i][1])){
                dsu.union(edges[i][0], edges[i][1]);
                wt += edges[i][2];
            }
        }

        return dsu.size > 1 ? Integer.MAX_VALUE: wt;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] e) {

        int[][] edges =new int[e.length][4];
        for(int i =0; i < e.length; i++){
            for(int j = 0; j < e[i].length; j++){
                edges[i][j] = e[i][j];
            }
            edges[i][3] = i;
        }
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        List<Integer> critical = new ArrayList<>();
        List<Integer> accepted = new ArrayList<>();

        int wt = kruskalAlgo(edges, accepted, n);

        List<Integer> pseudo_critical = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            int temp = edges[i][0];
            edges[i][0] = -1;
            int curr = kruskalAlgo(edges, accepted, n);

            if(curr > wt)
                critical.add(edges[i][3]);
            else{
                edges[i][0] = temp;
                accepted.add(i);
                if(kruskalAlgo(edges, accepted, n) == wt)
                    pseudo_critical.add(edges[i][3]);
                accepted.remove(accepted.size() - 1);
            }
            edges[i][0] = temp;
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo_critical);
        return ans;
    }
}