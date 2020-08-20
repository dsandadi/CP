import org.apache.commons.lang3.time.StopWatch;

import java.util.*;

public class E {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word: wordList) wordSet.add(word);
        wordSet.add(endWord);
        Queue<List<String>> qu = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        List<String> input = new ArrayList<>();
        input.add(beginWord);
        qu.offer(input);
        while(!qu.isEmpty()){
            int sz = qu.size();
            boolean dest_reached = false;
            for(int i = 0; i < sz; i++){
                List<String> curr = qu.poll();
                String node = curr.get(curr.size() - 1);
                visited.add(node);
                wordSet.remove(node);
                for(int j = 0; j < node.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        String word = node.substring(0, j) + c + node.substring(j + 1, node.length());
                        List<String> cur2 = new ArrayList<>(curr);
                        if(wordSet.contains(word) && !visited.contains(word)){
                            cur2.add(word);
                            if(word.equals(endWord)){
                                dest_reached = true;
                                ans.add(cur2);
                            }
                            else    qu.offer(cur2);
                        }
                    }
                }
            }
            if(dest_reached)   break;
        }
        return ans;
    }
    public static void main(String[] args) throws InterruptedException {
        E e = new E();
        Scanner sc = new Scanner(System.in);
        String beginWord = sc.nextLine();
        String endWord = sc.nextLine();
        String[] wordList = sc.nextLine().split("\\s");
        List<String> words = new ArrayList<>();
        int ind = 0;
        for(String word: wordList) words.add(word);
//        long startTime = System.nanoTime();
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(watch.getNanoTime());
        System.out.println(e.findLadders(beginWord, endWord, words));
        Thread.sleep(1000);
        watch.stop();
        long millis = watch.getNanoTime()/1000_000;
        System.out.println("Total execution time to create 1000K objects in Java using StopWatch in millis: "
                + millis);


//        long endTime = System.nanoTime();
//        System.out.println(((endTime - startTime)/1000) + " sec ");
    }
}
