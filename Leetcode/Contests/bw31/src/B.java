import java.util.HashMap;
import java.util.Map;

public class B {
        public int numOfSubarrays(int[] arr) {
            long oddsum = 0, evensum = 1;
//            mpr.put(0, (long)1);
            long sum = 0;
            int mod = (int)1e9 + 7;
            long ans = 0;
            for(int i = 0; i < arr.length; i++){
                sum += (long)arr[i];
                if(sum % 2 == 0){
                    ans += oddsum;
                    evensum++;
                }
                else{
                    ans += evensum;
                    oddsum++;
                }
                ans %= mod;
//                mpr.put((int)(sum % 2), mpr.getOrDefault((int)sum % 2, (long)0) + 1);
            }
            return (int)ans;
        }
    public static void main(String[] args){
        int[] arr = {1,3,5};
        B b = new B();
        System.out.println(b.numOfSubarrays(arr));
    }
}
