//import java.util.Arrays;
//import java.util.Scanner;
//
//public class D {
//
//    private static int fa(int k, int[] ar){
//        Arrays.sort(ar);
//        int[] offsets = new int[ar.length];
//        int ans = 0;
//        // take largest x value for which the things work!
//        for(int i = 0; i < ar.length; i++){
//            int val = (int) Math.ceil(ar[i]/(double)k);
//            offsets[i] = val * k - ar[i];
//        }
//        /*
//             1 2 3 4 5 6
//         */
//        for(int i = ar.length - 1; i >= 0; i--){
//            ans += offsets[i];
//        }
//        int ans = 0;
//        int prev = 0;
//        Arrays.sort(ar);
//        for(int i = 0; i < ar.length; i++){
//            ans += ar[i] - prev;
//            prev = ar[i];
//        }
//
//        return ans;
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int T = Integer.parseInt(sc.nextLine());
//        while(T > 0){
//            String[] digits = sc.nextLine().split("\\s");
//            int n = Integer.parseInt(digits[0]);
//            int k = Integer.parseInt(digits[1]);
//            int[] ar = new int[n];
//            digits = sc.nextLine().split("\\s");
//            for(int i = 0; i < n; i++)
//                ar[i] = Integer.parseInt(digits[i]);
//            System.out.println(fa(k, ar));
//            T--;
//        }
//    }
//}
