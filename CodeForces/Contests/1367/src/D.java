import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D {
    private String findAnswer(String s, int[] b){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        char[] dest = new char[b.length];

        for(int i = ch.length - 1; i >= 0; i--){
            int t = i;
            while(t >= 0 && ch[t] == ch[i])
                t--;
            t += 1;
            int counter = 0;
            List<Integer> cums = new ArrayList<>();
            for(int j = 0; j < b.length; j++){
                if(b[j] == 0 && dest[j] == 0){
                    cums.add(j);
                    counter++;
                }
            }
            if(cums.size() > (i - t + 1)){
                continue;
            }
            for(int j = 0; j < b.length; j++){
                if(b[j] == 0 && dest[j] == 0 && t <= i)
                    dest[j] = ch[t];
                for(Integer num: cums)
                    b[j] = Math.max(0, b[j] - Math.abs(j - num));
            }
            i = t;
            if(counter == b.length)
                break;
        }

        return new String(dest);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        D d = new D();
        while(T-- >  0){
            String s = sc.nextLine();
            int m = Integer.parseInt(sc.nextLine());
            int[] b= new int[m];
            String[] words = sc.nextLine().split("\\s");
            for(int i = 0; i < words.length; i++){
                b[i] = Integer.parseInt(words[i]);
            }
            System.out.println(d.findAnswer(s, b));
        }
    }
}
