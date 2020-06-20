import java.util.Scanner;

public class B {
    private int findMin(int[] ar){
        int evens = 0;
        int odds = 0;
        int misplaced = 0;
        for(int i = 0; i < ar.length; i++){
            if(ar[i] % 2 == 0)
                evens++;
            else
                odds++;
            if((i % 2 == 0) ^ ((ar[i] % 2) == 0))
                misplaced++;
        }

        return (ar.length % 2) == 0? evens == odds? misplaced/2: -1: evens == odds + 1? misplaced/2: -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        B b = new B();
        while(T-- >  0){
            int N = Integer.parseInt(sc.nextLine());
            String[] words = sc.nextLine().split("\\s");
            int[] ar = new int[N];
            for(int i = 0; i < ar.length; i++){
                ar[i] = Integer.parseInt(words[i]);
            }

            System.out.println(b.findMin(ar));
        }
    }
}
