import java.util.*;

public class ParallelCourses2 {
    int[] pre;
    int k;
    int n;
    int[] dp;
    private int dp(int available){
        if(available == ((1 << n) - 1))
            return 0;
//        if(dp[available] != -1)
//            return dp[available];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int curr = available;
            int counter = 0;
            int j = i;
            while(counter < k && j < n) {
                if ((available & (1 << j)) == 0 && ((pre[j] & available) == pre[j])) {
                    curr ^= (1 << j);
                    counter++;
                }
                j++;
            }
            if(curr != available){
                int val = dp(curr);

                if(val != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + val);
                dp[curr] = ans;
            }
        }
        return ans;
    }

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        Map<Integer, Integer> indegree = new HashMap<>();
        this.n = n;
        for(int i = 1; i <= n; i++)
            indegree.put(i, 0);

        // This array contains all the courses required by a destination course.
        pre = new int[n];
        for(int i = 0; i < dependencies.length; i++){
            int source = dependencies[i][0];
            int dest = dependencies[i][1];
            pre[dest - 1] ^= (1 << (source - 1));
        }

        this.k = k;
        this.dp = new int[1 << n];
        Arrays.fill(dp, -1);
        return dp(0);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ParallelCourses2 p2 = new ParallelCourses2();
        int[][] dependencies = {{2 , 1}, {3, 1}, {1, 4}};
        int k = 2;
        System.out.println(p2.minNumberOfSemesters(4, dependencies , k));
    }
}
