import java.util.HashSet;
import java.util.Set;

public class Simulation {
    static int MAX_DEPTH = 10;
    static Set<String> visited = new HashSet<>();
    private static String generateKey(int x, int y, int z){
        StringBuilder s1 = new StringBuilder();
        s1.append(Integer.toString(x) + Integer.toString(y) + Integer.toString(z));
        return s1.toString();
    }
    private static void simulator(int x, int y, int z){
        if(x >= MAX_DEPTH || y >= MAX_DEPTH  || z >= MAX_DEPTH || x <= -1*MAX_DEPTH || y <= -1*MAX_DEPTH || z <= -1*MAX_DEPTH
                || visited.contains(generateKey(x, y, z)))
            return ;
        if(Math.pow(x,3) + Math.pow(y,3) + Math.pow(z,3) == 33){
            System.out.println("Found");
            return ;
        }
        visited.add(generateKey(x, y, z));
        simulator(x + 1, y, z);
        simulator(x - 1, y, z);
        simulator(x, y + 1, z);
        simulator(x, y - 1, z);
        simulator(x, y, z - 1);
        simulator(x, y, z + 1 );
        return ;
    }
    public static void main(String[] args){
        simulator(0, 0, 0);
    }

}
