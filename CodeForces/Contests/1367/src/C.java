import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    private int fa(String s, int N, int K){
        int ans = 0;
        int[] next = new int[s.length()];

        int temp = s.length();
        for(int i = s.length() - 1; i >= 0; i--){
            next[i] = temp;
            if(s.charAt(i) == '1')  temp = i;
        }
        int prev = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                prev = i;
            }
            else if((prev == -1 || i - prev > K)  && (next[i] >= s.length() || next[i] - i > K)) {
                ans++;
                prev = i;
            }
        }
        return ans;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        C c = new C();
        while(T-- >  0){
            String[] words = sc.nextLine().split("\\s");
            int N = Integer.parseInt(words[0]);
            int K = Integer.parseInt(words[1]);
            String s = sc.nextLine();
            System.out.println(c.fa(s, N, K));
        }
    }
}
