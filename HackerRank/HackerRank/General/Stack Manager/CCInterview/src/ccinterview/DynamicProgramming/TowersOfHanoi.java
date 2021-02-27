/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccinterview.DynamicProgramming;

/**
 *
 * @author DINESH
 */
public class TowersOfHanoi {

    Tower[] towers;

    public TowersOfHanoi() {
        towers = new Tower[3];
        towers[0] = new Tower("A", 1);
        towers[1] = new Tower("B", 2);
        towers[2] = new Tower("C", 3);

    }

    private class Tower {

        String name;
        int number;

        public Tower(String name, int numb) {
            this.name = name;
            this.number = numb;
        }
    }

    public void slider(int number) {
        slideDisks(number, towers[0], towers[2], towers[1]);
    }

    private void slideDisks(int number, Tower source, Tower buffer, Tower dest) {
        if (number == 1) {
            System.out.println("Slide disc from Tower :" + source.name + " to tower :" + dest.name);
        } else {
            slideDisks(number - 1, source, dest, buffer);
            System.out.println("Slide disc from Tower :" + source.name + " to tower :" + dest.name);
            slideDisks(number - 1, buffer, source, dest);
        }
    }

    public static void main(String[] args) {
        TowersOfHanoi t = new TowersOfHanoi();
        t.slider(4);
    }

}
