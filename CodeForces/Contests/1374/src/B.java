import java.util.Scanner;

public class B {
    private static int fa(int n){
        int cnt2 = 0, cnt3 = 0;
        while(n % 2 == 0){
            n /= 2;
            cnt2++;
        }
        while(n % 3 == 0){
            n /= 3;
            cnt3++;
        }
        if(cnt2 > cnt3 || n != 1)
            return -1;

        return 2*cnt3 - cnt2;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while( T > 0){
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(fa(n));
            T--;
        }
    }
}
