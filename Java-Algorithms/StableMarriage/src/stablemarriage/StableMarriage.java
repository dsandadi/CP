/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stablemarriage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DINESH
 */
public class StableMarriage {

    int men, wmen;
    Integer[][] m;
    Integer[][] w;
    HashMap<Integer, Integer> engaged;
    ArrayList<Integer> freeMen = new ArrayList<>();
    ArrayList<Integer> freeWomen = new ArrayList<>();

    public StableMarriage(int men, int wmen) {
        this.men = men;
        this.wmen = wmen;
        engaged = new HashMap<>();

        m = new Integer[men][wmen];

        w = new Integer[wmen][men];

        for (int i = 0; i < men; i++) {
            freeMen.add(i);
        }

        for (int i = 0; i < wmen; i++) {
            freeWomen.add(i);
        }
    }

    boolean isFree(int index, boolean isMen) {
        if (isMen) {
            return freeMen.contains(index);
        } else {
            boolean a = freeWomen.contains(index);
            return a;
        }

    }

    void engage(int mIndex, int wIndex) {

        engaged.put(wIndex, mIndex);

    }

    boolean likesToChange(int mIndex, int wIndex) {

        if (engaged.containsKey(wIndex)) {
            Integer[] a = w[wIndex];
            List<Integer> k = Arrays.asList(a);
            int selectPrior = k.indexOf(new Integer(mIndex));
            int engagedPrior = k.indexOf(new Integer(engaged.get(wIndex)));
            return (selectPrior < engagedPrior);
            // return (w[wIndex][mIndex] < w[wIndex][engaged.get(wIndex)]);
        } else {
            return false;
        }

    }

    void process() {
        int j = 0;
        while (freeMen.size() != 0) //for(int i =0;i < m.length;i++)
        {

            // for (int i = 0; i < m.length; i++) {
            //   if (!freeMen.contains(i)) {
            //     break;
            //}
            for (int i = 0; i < freeMen.size(); i++) {

                // int row = freeMen.get(i);
                int row = freeMen.get(i);
                int col = j;
                int wIndex = m[row][col] ;
                int mIndex = row;

                if (isFree(wIndex, false)) {
                    engage(mIndex, wIndex);
                    freeMen.remove(new Integer(mIndex));
                    i--;
                    freeWomen.remove(new Integer(wIndex));    
                //            freeWomen.remove(freeWomen.lastIndexOf(wIndex));
                } else if (likesToChange(mIndex, wIndex)) {
                    freeMen.add(engaged.get(wIndex));
                    engaged.remove(wIndex);
                    i--;
                    engage(mIndex, wIndex);
                    freeMen.remove(new Integer(mIndex));
                }
            }
           // freeEngagedMen(j);
            //freeEngagedWomen();
            j++;
        }
    }

    //public void freeEngagedWomen() {
    //  for (Map.Entry<Integer, Integer> entry : engaged.entrySet()) {
    //if (freeMen.contains(entry.getValue())) {
    //    freeMen.remove(entry.getValue());
    //  }
    //}
    public boolean isEngaged(int mIndex, int priority) {
        int b = m[mIndex][priority];
        int a = w[m[mIndex][priority]][priority];
        return a == b;
    }

    public void freeEngagedMen(int priority) {

        for (int i = 0; i < m.length; i++) {
            if (isEngaged(i, priority)) {
                freeMen.remove(i);
                System.out.println("Removed Men: " + i);
                System.out.println("Total free men :" + freeMen.size());
            }
        }
    }

    public void displayEngaged() {
        System.out.println("Total Engaged couples are :" + engaged.size());
        for (Map.Entry<Integer, Integer> entry : engaged.entrySet()) {
            System.out.println("Women " + entry.getKey() + " is engaged to men " + entry.getValue());
        }

    }

    public void loadData() {
//        int men, wmen;
        Scanner sc = new Scanner(System.in);
        //      System.out.println("Enter the number of women.");
        //  wmen = sc.nextInt();
        //    System.out.println("Enter tht number of men.");
        //men = sc.nextInt();

        System.out.println("Enter men's preferences");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < w.length; j++) {
                m[i][j] = sc.nextInt()-1;
            }
        }
        System.out.println("Enter women's preferences");

//System.out.println("men are"+men);
        for (int i = 0; i < wmen; i++) {
            for (int j = 0; j < men; j++) {
                w[i][j] = sc.nextInt()-1;
            }
        }
    }

    public static void main(String args[]) {
        int men, wmen;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of women.");
        wmen = sc.nextInt();
        System.out.println("Enter tht number of men.");
        men = sc.nextInt();

        StableMarriage m1 = new StableMarriage(men, wmen);
        m1.loadData();
        m1.process();
        m1.displayEngaged();

        //data input is done.
        /**
         * *******************************************************************
         */
        //process the data.
    }

    /**
     * @param args the command line arguments
     */
    //  public static void main(String[] args) {
    // TODO code application logic here
    // }
}
