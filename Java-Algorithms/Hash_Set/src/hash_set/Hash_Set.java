/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_set;

import java.util.HashSet;

/**
 *
 * @author DINESH
 */
public class Hash_Set {

    public class employee {

        int age;
        int id ;
        String name;

       // @Override
        public int hashCode() {
            System.out.println("HASHCODE: Called Me.");
            return age;
        }

        @Override
        public boolean equals(Object o)
        {
            //if(this != o) return false;
            System.out.println("EQUALS: Called Me");
            employee e = (employee)o;
            return e.age == this.age;
            
        }
                employee(int id, int age, String name) {
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hash_Set h1 = new Hash_Set();
        HashSet<employee> test = new HashSet<employee>();
        test.add(h1.new employee(129,21, "Dinesh"));
        test.add(h1.new employee(130,21, "Sandadi"));
        System.out.println("Does HashMap has Sandadi ? " + test.contains(h1.new employee(150,20, "Sandadi")));
    }

}
