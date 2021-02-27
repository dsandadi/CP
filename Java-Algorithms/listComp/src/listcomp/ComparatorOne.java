/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listcomp;

import java.util.Comparator;

/**
 *
 * @author DINESH
 */
public class ComparatorOne implements Comparator<Student> {
    public int compare(Student s1, Student s2)
    {
        return s1.getAge() - s2.getAge();
    }
}
