package com.company;

import java.util.Arrays;

public class C {
        int[] sfx;
        int[] houses;
        private int distance(int ind1, int ind2){
            int mid = (houses[ind1] + houses[ind2])/2;
            int ans = 0;
            for(int i = ind1; i <= ind1; i++){
                if(houses[i] < mid) ans -= houses[i];
                else ans += houses[i];
            }
            return ans;
        }
        private int dp(int st, int k){
            if(st >= houses.length) return 0;
            if(k == 0)  return Integer.MAX_VALUE;

            int ans = Integer.MAX_VALUE;

            for(int i = st; i < houses.length; i++){
                int val = distance(i, st);
                int d1 = dp(i + 1, k - 1);
                if(d1 != Integer.MAX_VALUE)
                    ans = Math.min(ans, val + d1);
            }

            return ans;
        }
        public int minDistance(int[] houses, int k) {
            Arrays.sort(houses);
            sfx = new int[houses.length];
            int sum = 0;
            this.houses = houses;
            for(int i= houses.length - 1; i >= 0; i--){
                sum += houses[i];
                sfx[i] = sum;
            }
            return dp(0, k);
        }
        public static void main(String[] args){
            C c = new C();
            int[] arr = {1,4,8,10,20};
            System.out.println("Hello from C");
            System.out.println(c.minDistance(arr, 3));
        }
}
