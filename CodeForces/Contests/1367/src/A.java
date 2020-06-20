import java.util.Scanner;

public class A {
    private String fa(String word){
        StringBuilder ans = new StringBuilder();
        ans.append(word.charAt(0));
        for(int i = 1; i < word.length() - 1; i+=2){
            ans.append(word.charAt(i));
        }
        if(word.length() > 1);
            ans.append(word.charAt(word.length() - 1));
        return ans.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        A a = new A();
        while(T-- >  0){
            String word = sc.nextLine();
            System.out.println(a.fa(word));
        }
    }
}
