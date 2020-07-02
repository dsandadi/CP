import java.util.Arrays;
import java.util.Scanner;

public class CampusBikes2 {
    private static int mh(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    private static int count_set_bits(int num){
        int count = 0;
        while(num != 0){
            count++;
            num &= num - 1;

        }
        return count;
    }
    public static int assignBikes(int[][] workers, int[][] bikes) {
        int[][] dp = new int[1 << workers.length][bikes.length];
        for(int[] a: dp)
            Arrays.fill(a, Integer.MAX_VALUE);

        for(int k = 0; k < bikes.length; k++){
            for(int mask = 0; mask < (1 << workers.length); mask++){
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < workers.length; j++){
                    if((mask & (1 << j)) == 0){                         // worker is not assigned any bike
                        int dist = mh(workers[j], bikes[k]);
                        int val = (k >= 1)? dp[mask][k - 1] + dist: dist;
                        dp[mask | (1 << j)][k] = Math.min(dp[mask | (1 << j)][k], val);
                    }
                }
            }
        }

        return dp[(1 << workers.length) - 1][workers.length - 1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] workers = {{239,904},{191,103},{260,117},{86,78},{747,62}};
        int[][] bikes = {{660,8},{431,772},{78,576},{894,481},{451,730},{155,28}};
//        int[][] workers = {{0,0}, {2,1}};
//        int[][] bikes = {{1,2}, {3,3}};
        System.out.println(assignBikes(workers, bikes));

    }
}
