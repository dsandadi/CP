import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    private static int[] fp(int[] ar, int n){
        int sz = 0;
        int idx = 0;
        int[] ans = new int[n];
        Set<Integer> visited = new HashSet<>();
        while(sz < n && idx < ar.length){
            int cur =ar[idx++];
            if(visited.contains(cur)) continue;
            visited.add(cur);
            ans[sz++] = cur;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T > 0){
            int n = Integer.parseInt(sc.nextLine());
            String[] words = sc.nextLine().split("\\s");
            int[] ar = new int[2*n];
            for(int i = 0; i < words.length; i++){
                ar[i] = Integer.parseInt(words[i]);
            }
            int[] ans = fp(ar, n);
            for(Integer num: ans)   System.out.print(num + " ");
            System.out.println();
            T--;
        }
    }
}
