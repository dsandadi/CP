import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B {
        private int calculateInteger(int[] cells){
            int power = 0;
            int ans = 0;
            for(int i = cells.length - 1; i >= 0; i--)  ans += (Math.pow(2, power++)*cells[i]);
            return ans;
        }
        public int[] prisonAfterNDays(int[] cells, int N) {
            Map<Integer, Integer> mpr = new HashMap<>();
            Map<Integer, int[]> day_mutations = new HashMap<>();
            int curr_value = calculateInteger(cells);;
            mpr.put(curr_value, 0);
            int day = 1;

            for(; day <= N; day++){
                int prev = 0;
                for(int i = 1; i < cells.length - 1; i++){
                    int temp = cells[i];
                    cells[i] = ((prev ^ cells[i + 1]) == 1)? 0: 1;
                    // System.out.println(prev + " :: " + cells[i + 1] + " value " + (prev ^ cells[i + 1]));
                    prev = temp;
                }
                cells[0] = 0;
                cells[cells.length - 1] = 0;
                curr_value = calculateInteger(cells);
                // System.out.println(day + " " + Arrays.toString(cells));
                if(mpr.containsKey(curr_value))
                    break;
                mpr.put(curr_value, day);
                System.out.println(day + " " + Arrays.toString(cells));
                day_mutations.put(day, cells.clone());
            }

            int start_day = mpr.get(curr_value);
            int end_day = day;

            System.out.println(start_day + " :: " + end_day);
            for(Map.Entry<Integer, int[]> entry: day_mutations.entrySet())
                System.out.println(entry.getKey() + " :: " + Arrays.toString(entry.getValue()));
            // System.out.println(day_mutations);
            int mod = end_day - start_day;
            return day_mutations.get(start_day + ((N - end_day) % mod));
        }
        private int[] bruteForce(int[] cells, int N){
            int day = 1;
            for(; day <= N; day++){
                int prev = cells[0];
                for(int i = 1; i < cells.length - 1; i++){
                    int temp = cells[i];
                    cells[i] = ((prev ^ cells[i + 1]) == 1)? 0: 1;
                    prev = temp;
                }
                cells[0] = 0;
                cells[cells.length - 1] = 0;
            }
            return cells;
        }
        public static void main(String[] args){
            B b = new B();
            int[] ar = {0,1,0,1,1,0,0,1};
            int N = 7;
            System.out.println(Arrays.toString(b.prisonAfterNDays(ar, N)));
        }

//         Map<Integer, Integer> mutations = new HashMap<>();
//         // mutations.put(0, calculateInteger(cells));
//         Map<Integer, int[]> day_mutations = new HashMap<>();
//         for(int day = 1; day <= N; day++){
//             int prev = cells[0];
//             int val = calculateInteger(cells);
//             if(mutations.containsKey(val)){
//                 System.out.println("Here" + Arrays.toString(cells) + day + " :: " + mutations.get(val));
//                 int curr_day = Math.min(day + day - mutations.get(val), N);
//                 day_mutations.put(curr_day, day_mutations.get(mutations.get(val) + N - day));
//                 day = curr_day;
//                 cells = day_mutations.get(curr_day);
//             }
//             else{
//                 int curr_value = calculateInteger(cells);
//                 mutations.put(curr_value, day);
//                 day_mutations.put(day, cells);
//                 for(int i = 1; i < cells.length - 1; i++){
//                     int temp = cells[i];
//                     cells[i] = ((prev ^ cells[i + 1]) == 1)? 0: 1;
//                     prev = temp;
//                 }
//                 cells[0] = 0;
//                 cells[cells.length - 1] = 0;

//             }
//         }
//         return day_mutations.get(N);
}
