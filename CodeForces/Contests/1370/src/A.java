import java.util.Scanner;

public class A {
    private static int maxGcd(int m){
        for(int i = m; i > 0; i--){
            if(i * 2 <= m)
                return i;
        }
        return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-- >  0){
            int m = Integer.parseInt(sc.nextLine());
            System.out.println(maxGcd(m));
        }
    }
}
