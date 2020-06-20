package com.company;

import java.util.Scanner;

public class Main {

    private void printAnswer(int[] a, int[] b){
        for(int i = 1; i < b.length; i++){
            if(b[i] != b[i - 1]){
                System.out.println("Yes");
                return ;
            }
        }
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i - 1]){
                System.out.println("No");
                return ;
            }
        }
        System.out.println("Yes");
        return ;
    }

    public static void main(String[] args) {
	// write your code here
//        B b = new B();


//        Main a = new Main();
//
//
//        Scanner sc = new Scanner(System.in);
//        int T = Integer.parseInt(sc.nextLine());
//        while(T > 0){
//            int N = Integer.parseInt(sc.nextLine());
//            int[] li = new int[N];
//            String[] words = sc.nextLine().split("\\s");
//            for(int i = 0; i < N; i++){
//                li[i] = Integer.parseInt(words[i]);
//            }
//            int[] b= new int[N];
//            words = sc.nextLine().split("\\s");
//            for(int i = 0; i < N; i++){
//                b[i] = Integer.parseInt(words[i]);
//            }
//            a.printAnswer(li, b);
//
//            T--;
//        }
    }
}
