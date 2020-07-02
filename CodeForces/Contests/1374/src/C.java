import java.util.Scanner;

public class C {
    private static int fa(String ip, int n){
        int open = 0;
        int closed = 0;
        int ans = 0;
        for(int i = 0; i < ip.length() && (open + closed < n); i++){
            if(ip.charAt(i) == '(') open++;
            else closed++;

            if(closed > open){
                ans++;
                open++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T > 0){
            int n = Integer.parseInt(sc.nextLine());
            String ip = sc.nextLine();
            System.out.println(fa(ip, n));
            T--;
        }
    }
}
