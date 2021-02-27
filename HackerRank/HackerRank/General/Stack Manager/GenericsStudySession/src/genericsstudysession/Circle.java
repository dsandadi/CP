/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericsstudysession;

/**
 *
 * @author DINESH
 */
public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a circle");

    }

    @Override
    public void display() {
        System.out.println("displaying a circle");
    }
    public String toString(){
    return "I am a circle";
    }

}
