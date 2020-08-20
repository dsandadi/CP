import java.util.Scanner;

public class A {
    private static void findAnswer(int x, int y, int z){
        int a = -1, b = -1, c = -1;
        if(Math.max(x, y) == Math.max(y, z) && Math.max(x, z) == Math.max(y, z)){
            int maxi = Math.max(Math.max(x, y), z);
            System.out.println("YES");
            if(x != maxi)
                System.out.println(maxi+ " " + x + " " + 1);
            else if(y != maxi)
                System.out.println(maxi + " " + y + " " + 1);
            else if(z != maxi)
                System.out.println(maxi + " " + z + " " + 1);
            else
                System.out.println(x + " " + y + " " + z);
        }
        else System.out.println("NO");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T > 0){
            String[] words = sc.nextLine().split("\\s");
            int x = Integer.parseInt(words[0]);
            int y = Integer.parseInt(words[1]);
            int z = Integer.parseInt(words[2]);
            findAnswer(x, y, z);
            T--;
        }
    }
}
