import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maxSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. 2D_INTEGER_ARRAY edges
     */

    static Map<Integer, List<Integer>> adjList;
    static int N;
    private static long bfs(int src){
        Queue<Integer> q = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] distances = new int[N];
        q.offer(src);
        long ans = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                src = q.poll();
                List<Integer> neighbors = adjList.getOrDefault(src, new ArrayList<>());
                set.add(src);
                for(Integer neighbor: neighbors){
                    Integer higher = set.higher(neighbor);
                    distances[neighbor] = distances[src] + 1;
                    if(higher != null)
                        distances[neighbor] = Math.min(distances[neighbor], distances[higher]);
                    ans += distances[neighbor];
                }
            }
        }
        return ans;
    }
    public static long maxSum(int N, List<List<Integer>> edges) {
        // Write your code here
        adjList = new HashMap<>();
        Result.N = N;
        for(List<Integer> edge: edges){
            int src = edge.get(0) - 1, dest = edge.get(1) - 1;
            List<Integer> li1 = adjList.getOrDefault(src, new ArrayList<>());
            List<Integer> li2 = adjList.getOrDefault(dest, new ArrayList<>());
            li1.add(dest);
            li2.add(src);
            adjList.put(src, li1);
            adjList.put(dest, li2);
        }
        return bfs(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] digits = sc.nextLine();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int N = Integer.parseInt(firstMultipleInput[0]);

        int M = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> edgesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                edgesRowItems.add(edgesItem);
            }

            edges.add(edgesRowItems);
        }

        long result = Result.maxSum(N, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
