import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    private static int counter(int[] ar){
        int ans = 0;
        int st = 0, en = ar.length - 1;
        while(st < en && ar[en] <= ar[en - 1])  en--;
        for(; st < en; st++){
            ans = Math.max(ans, st);
            while(st < en && ar[st] <= ar[st + 1]) st++;
        }
       return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T > 0){
            int n = Integer.parseInt(sc.nextLine());
            String[] words = sc.nextLine().split("\\s");
            int[] ar =new int[words.length];
            for(int i = 0; i < ar.length; i++) ar[i] = Integer.parseInt(words[i]);
            System.out.println(counter(ar));
            T--;
        }
    }
}
