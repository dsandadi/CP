/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author DINESH
 */
public class Child extends Parent{ 
    public void feeds()
    {
    System.out.println("Doesn't feed family");
    }
    public void attends()
    {
        System.out.println("Goes to Metea valley High School");
    }
public static void main(String args[])
{
    Parent p1 = new Parent();
    Child c1 = (Child) p1;
    c1.feeds();
}
}
