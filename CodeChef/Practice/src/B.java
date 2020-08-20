import java.util.Scanner;

public class B {
    private static int lcm(int a, int b){
        return a*b/gcd(a, b);
    }
    private static int gcd(int a, int b){
        if(b == 0)  return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-- > 0){
            String[] digits = sc.nextLine().split("\\s");
            int N = Integer.parseInt(digits[0]);
            int a = Integer.parseInt(digits[1]);
            int b = Integer.parseInt(digits[2]);
            int k = Integer.parseInt(digits[3]);
            int lcm = lcm(a, b);
            int val = (a == 0? 0: N / a)  +  (b == 0? 0: N / b) - (2*(N / lcm));
            if(val >= k)
                System.out.println("Win");
            else
                System.out.println("Lose");
        }
    }
}
