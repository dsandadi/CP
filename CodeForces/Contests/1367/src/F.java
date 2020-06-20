import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class F {
    int ans = Integer.MAX_VALUE;
    Set<Integer> visited = new HashSet<>();
    private boolean isSorted(LinkedList<Integer> ar){
        for(int i= 1; i < ar.size(); i++){
            if(ar.get(i) < ar.get(i - 1))
                return false;
        }
        return true;
    }

    private void backtrack(LinkedList<Integer> ar, int steps){
        if(isSorted(ar)){
            ans = Math.min(ans, steps);
            return ;
        }

        for(int i = 0; i < ar.size(); i++){
            if(!visited.contains(ar.get(i))){
                visited.add(ar.get(i));
                backtrack(ar, steps);
                int val = ar.get(i);
                ar.remove(i);
                ar.addFirst(val);
                backtrack(ar, i == 0? steps: steps + 1);
                ar.removeFirst();
                ar.addLast(val);
                backtrack(ar, i == ar.size() - 1? steps: steps + 1);
                ar.removeLast();
                ar.add(i, val);
                visited.remove(ar.get(i));
            }

        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-- >  0){

            F f = new F();
            int n = Integer.parseInt(sc.nextLine());
            LinkedList<Integer> ar = new LinkedList<>();
            String[] digits = sc.nextLine().split("\\s");
            for(int i = 0; i < digits.length; i++){
                ar.addLast(Integer.parseInt(digits[i]));
            }
            f.backtrack(ar, 0);
            System.out.println(f.ans);
        }
    }
}
