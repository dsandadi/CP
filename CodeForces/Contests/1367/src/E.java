import java.util.*;

public class E {

    private int findAnswer(String s, int n, int k){
        int[] cnt = new int[26];
        for(int i =0; i < s.length(); i++)  cnt[s.charAt(i) - 'a']++;

        for(int len = n; len >= 1; len--){
            boolean[] used = new boolean[n];
            List<Integer> cycles = new ArrayList<>();
            for(int i = 0; i < len; i++){
                if(used[i]) continue;

                int j = (i + k) % len;
                used[i] = true;
                int counter = 1;
                while(!used[j]){
                    counter++;
                    used[j] = true;
                    j = (j + k) % len;
                }

                cycles.add(counter);
            }

            int[] current = cnt.clone();
            Arrays.sort(current);
            Collections.sort(cycles);
            int j = cnt.length - 1;
            boolean can_fill = true;
            for(int i = cycles.size() - 1; i >= 0; i--){
                if(j < 0 || current[j] < cycles.get(i)){
                    can_fill = false;
                    break;
                }
                else{
                    current[j] -= cycles.get(i);
                    Arrays.sort(current);
                }
            }
            if(can_fill)
                return len;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        E e = new E();
        while(T-- >  0){
            String[] words = sc.nextLine().split("\\s");
            int n = Integer.parseInt(words[0]);
            int k = Integer.parseInt(words[1]);
            String s = sc.nextLine();
            System.out.println(e.findAnswer(s, n, k));
        }
    }
}
