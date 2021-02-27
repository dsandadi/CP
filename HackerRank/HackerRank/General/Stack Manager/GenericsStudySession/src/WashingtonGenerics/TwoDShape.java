/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WashingtonGenerics;

/**
 *
 * @author DINESH
 */
public interface TwoDShape<T extends TwoDShape> extends Shape<T>{
    public void display();
}
