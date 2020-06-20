import java.util.Arrays;
import java.util.Scanner;

public class Permute {
    int counter = 0;
    private void swap(int i1, int i2, char[] ch){
        char t1 = ch[i1];
        ch[i1] = ch[i2];
        ch[i2] = t1;
        return ;
    }
    private void subsets(int[] ar){
        for(int i = 0; i < (1 << ar.length); i++){
            for(int j = 0; j < ar.length; j++){
                if((j & i) == 1){

                }
            }
        }
    }
    private void permute(int ind, char[] curr){
        if(ind >= curr.length){
            System.out.println(new String(curr));
            counter++;
            return ;
        }
        for(int i = ind; i < curr.length; i++){
            swap(i, ind, curr);
            permute(ind + 1, curr);
            swap(i, ind, curr);
        }
        return ;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Permute p1 = new Permute();
        String input = sc.nextLine();
        char[] t1 = input.toCharArray();
        p1.permute(0, t1);
        System.out.println("Total permutations: " + p1.counter);
    }
}
