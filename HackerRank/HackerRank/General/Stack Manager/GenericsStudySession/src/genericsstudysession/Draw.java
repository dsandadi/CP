/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericsstudysession;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DINESH
 */
public class Draw {

    public<T> T create(T s) {
       // System.out.println(s);
       T a = null; return a;
    }
//    public void DrawAll(List<? extends Shape> shapes){
//    }

    public void print( List< ? extends Shape> shapes) {
        for (Shape o : shapes) {
            System.out.println(o);
        }

        List<Rectangle> r = new ArrayList<>();
        r.add(new Rectangle());

        shapes.add(r);
//        shapes.add(new Shape());
    }

    public static void main(String[] args) {
        Draw<Rectangle> d = new Draw<>();
        Rectangle s = new Rectangle();
        List<Rectangle> a = new ArrayList<>();
        a.add(s);
        d.print(a);
//        System.out.println("=======================");
//        List<Circle> b = new ArrayList<>();
//        Circle c = new Circle();
//        b.add(c);
//        d.print(b);
    }
}
