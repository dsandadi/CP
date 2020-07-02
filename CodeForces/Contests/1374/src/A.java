import java.util.Scanner;

public class A {
    private static int fa(int x, int y, int n){
       return (x*((n - y)/x)) + y;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-- > 0){
            String[] words = sc.nextLine().split("\\s");
            System.out.println(fa(Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2])));
        }
        return ;
    }
}
