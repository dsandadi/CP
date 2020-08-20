import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class C {
    public static int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];
        for(int[] ar: graph) Arrays.fill(ar, -1);
        for(int i =0; i < edges.length; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            graph[src][dest] = edges[i][2];
            graph[dest][src] = edges[i][2];
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        int res = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dist = curr[1];
            int start = curr[0];
            if(visited.contains(start)) continue;
            res++;
            visited.add(start);
            for(int i = 0; i < N; i++){
                if(graph[start][i] > -1){
                    int wt = graph[start][i];
                    if(wt + dist < M)  pq.offer(new int[]{i, wt + dist + 1});
                    graph[i][start] -= Math.min(wt, M - dist);
                    res += Math.min(wt, M - dist);
                }
            }
        }
        return res;
    }

    /*
    [[1,2,5],[0,3,3],[1,3,2],[2,3,4],[0,4,1]]
    7
    5
    */
    public static void main(String[] args){
        int[][] edges = {{0, 1, 10},{0,2,1},{1,2,2}};
        System.out.println(reachableNodes(edges, 6, 3));
    }
}
