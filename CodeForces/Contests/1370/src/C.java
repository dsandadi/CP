import java.util.Scanner;

public class C {
    private static String findAnswer(int num){
        boolean[] dp = new boolean[num + 1];
        dp[1] = false;
        for(int i = 2;i <= num; i++){
            dp[i] |= !dp[i - 1];
            if(dp[i]) continue;
            for(int j = i % 2 == 0? i - 1: i; j > 1; j -= 2){
                if(i % j == 0)  dp[i] |= !dp[i/j];
            }
        }
        return dp[num] ? "Ashishgup": "FastestFinger";
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-- >  0){
            int m = Integer.parseInt(sc.nextLine());
            System.out.println(findAnswer(m));
        }
    }
}
