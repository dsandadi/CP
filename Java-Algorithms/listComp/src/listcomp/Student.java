/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listcomp;

import java.util.Arrays;

/**
 *
 * @author DINESH
 */
public class Student {
   
    /**
    * @param args the command line arguments
     */
    private int age;
    private int rollNumber;
    private String name;
    public void setName(String name)
    {
        this.name = name; 
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setRollNumber(int rollNumber)
    {
        this.rollNumber = rollNumber;
    }
    public int getAge()
    {
        return age;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Student [] s1 = new Student[13];
        int a = 19;
        String n = "dinesh";
        int r = 129;
        for(int i = 0; i < 13; i++ )
        {  
            s1[i] = new Student();           
            s1[i].setAge(a++); 
            s1[i].setName(n);
            s1[i].setRollNumber(r++);
        }
        Arrays.sort(s1,new ComparatorOne());
       
    }
    public MyIterator implements Iterable<Student>{
    
    
}}
