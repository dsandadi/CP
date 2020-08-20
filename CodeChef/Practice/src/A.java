import java.util.Scanner;

public class A {
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-- > 0){
            String[] digits = sc.nextLine().split("\\s");
            int a = Integer.parseInt(digits[0]);
            int b = Integer.parseInt(digits[1]);
            System.out.println(gcd(a, b));
        }
    }
}
