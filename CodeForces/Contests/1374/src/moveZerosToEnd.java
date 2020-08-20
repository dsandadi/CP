import java.util.Arrays;
import java.util.EmptyStackException;

public class moveZerosToEnd {
    private static void moveZerosToEnd(int[] ar) throws Exception {
        throw new EmptyStackException();
    }
    private static void bruteForce(int[] ar){
        int[] ar2 = new int[ar.length];
        int i2 = 0;
        for(int i = 0; i < ar.length; i++){
            if(ar[i] == 1)
                ar2[i2++] = 1;
        }
        for(int i = 0; i < ar.length; i++)
            ar[i] = 1;
        return ;
    }
    private static boolean equal_elments(int[] ar, int[] ar2){
        if(ar.length != ar2.length) return false;
        for(int i = 0; i < ar.length; i++){
            if(ar[i] != ar2[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        int[] ar = {0,1,0,1,1,1,0};
        int[] ar2 = {0,1,0,1,1,1,0};
        moveZerosToEnd(ar);
        bruteForce(ar2);

        assert equal_elments(ar, ar2) : " Incorrect";
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(ar2));
    }
}
