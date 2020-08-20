import java.util.Scanner;

public class Pascal {
    private static int factorial(int number){
        int ans = 1;
        for(int i = 1; i <= number; i++) ans *= i;
        return ans;
    }
    private static int ncr(int n, int r){
        return factorial(n)/(factorial(r)*factorial(n - r));
    }
    private static void printPascal(int n){
        for(int i = 0; i < n; i++){
            int offset = n - i - 1;
            while(offset-- > 0)     System.out.print(" ");
            for(int j =0; j <= i; j++)      System.out.print(ncr(i, j) + " ");
            System.out.println();
        }
        return ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        printPascal(number);
    }
}
