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
public class Rectangle extends Shape {

    public void draw() {
        System.out.println("drawing Rectangle");
    }

    @Override
    public void display() {
        System.out.println("displaying a rectangle");
    }

    public String toString() {
        return "I am a rectangle.";
    }
}
