package hw4;

/**
 * ***************************************************************
 *
 * Course : CSCI 680-E Program : Assignment 4 Author : Dinesh Sandadi Z-number:
 * z1797942 Date Due : 05/05/2017 Purpose : This program reads the movie names
 * and replaces the latin characters, and creates a serializable file. .
 * Execution: java Hw4
 *
 ********************************************************************
 */
//import libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author DINESH
 */
/**
 * ******************************************************************************
 * class name : Hw4a author : DINESH SANDADI Purpose : This class contains
 * methods that reads the movie names and replaces the latin characters,and
 * creates a serializable file.
 * *******************************************************************************
 */
public class Hw4a implements java.io.Serializable {

    //private static Formatter output;
    private HashMap<Character, Character> map;//hash map
    private ArrayList<ArrayList<Integer>> matrix;//arraylist.
    public HashMap<Integer, String> movies;
    private final int totalCols = 943;
    private static final long serialVersionUID = 1113799434508676095L;

    /**
     * @param args the command line arguments
     */
    /**
     * ***************************************
     * Constructor : Hw4
     *
     * Description : This method constructs the Hw4
     *
     ***
     */
    public Hw4a() {
        map = new HashMap<Character, Character>();//initializing map
        //inserting character into map.
        map.put('é', 'e');
        map.put('Á', 'A');
        map.put('ö', 'o');
        map.put('è', 'e');
        //creating a new ArrayList.
        matrix = new ArrayList<ArrayList<Integer>>();
        movies = new HashMap<Integer, String>();

    }

    /**
     * *****
     * Method : getMatrix Purpose : gets the matrix.
     */
    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;

    }

    /**
     * *****
     * Method : readFile Purpose :reads the movie names and replaces the latin
     * characters,and creates a serializable file.
     */

    public void readFile() {

        try {
            Formatter output = new Formatter("movie-names2.txt");//initializing new formatter.
            try {
                Scanner sc = new Scanner(new File("movie-names.txt"), "ISO-8859-1");//creating a new scanner.
                int lineNumber = 0;//initializing lineNumber to zero.
                int highLines = 0;
                int highChars = 0;
                //setting delimiter.
                sc.useDelimiter("|\n");
                boolean lineContainsHigh;
                //while loop to get the line and process each line.
                while (sc.hasNextLine()) {
                    lineNumber++;//increamenting lineNumber. 
                    lineContainsHigh = false;
                    StringBuilder line = new StringBuilder(sc.nextLine());//initializing StringBuilder.
                    //System.out.println(line);
                    //for loop to itertate through each line.
                    for (int i = 0; i < line.length(); i++) {
                        //checking the character.
                        if (line.charAt(i) > 128) {
                            lineContainsHigh = true;
                            highChars++;//incrementing highChars.
                            System.out.printf("non-Ascii char: %c in line %d char %d\n%s\n", line.charAt(i), lineNumber, i, line);
                            //if map contains the elements then replace with the proper value.
                            if (map.containsKey(line.charAt(i))) {
                                line.setCharAt(i, map.get(line.charAt(i)));

                            }
                        }
                    }
                    if (lineContainsHigh) {
                        highLines++;
                    }
                    //creating a new scanner.
                    Scanner sc2 = new Scanner(line.toString());
                    //using regex to seperate the parts of the line.
                    sc2.useDelimiter("\\||\\([1-9]");
                    //extraction.
                    String a = sc2.next();
                    String b = sc2.next();
                    movies.put(Integer.parseInt(a), b);//putting in to movies map.
                    output.format("%-4s %s%n", a, b);// writtting in to the file.

                }
                System.out.println("No. of high order chars:" + highChars);
                System.out.println("No. of high order lines:" + highLines);
                System.out.println("Total record count:" + lineNumber);

                output.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Specified file is not Found." + ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File specified is not found: " + ex);
        }
    }

    /**
     * ******************
     * Method : createMatrix Purpose : This method creates the matrix by taking
     * the data from given \ file.
     */
    public void createMatrix(FileReader f) {
        Scanner sc = new Scanner(f);//initializing a new scanner.
        int lineN = 0;//initializing lineN to zero.
        int currentTotalCols;
        boolean correct = true;
        //while loop to access each line.
        while (sc.hasNextLine()) {
            currentTotalCols = 0;
            ArrayList<Integer> a = new ArrayList<Integer>();
            lineN++;
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line);
            //seperating string.
            sc2.useDelimiter(";");
            if (line.charAt(0) == ';') {
                currentTotalCols++;
		a.add(-1);//adding -1 in the place of empty spaces.
            }
            //As long as the sc2 has next items.
            while (sc2.hasNext()) {
                currentTotalCols++;//increment the currenttotalCols.

                String t = sc2.next();
                //if t is empty.
                if (t.isEmpty()) {
                    a.add(-1);
                } else {
                    a.add(Integer.parseInt(t));
                }
            }
            //if all the columns are not filled. due to scanner inefficiency.
            while (currentTotalCols != totalCols) {
                a.add(-1);
                currentTotalCols++;
            }
            matrix.add(a);//adding to the matrix.
        }
    }

    /**
     * ******************
     * Method : displayMatrix Purpose : This method displays the matrix .
     */
    public void displayMatrix() {
        boolean same = true;
        // a loop to iterate through matrix.
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).size() != totalCols) {
                same = false;
            }
        }
        //printing the details.
        System.out.println("*** No. of rows (movies)in matrix = " + matrix.size());
        System.out.println("*** No. of columns (reviewers)in matrix = " + totalCols);
        if (same) {
            System.out.println("All rows have same number of reviewers");
        }
    }

    /**
     * **
     * Method : serialize() Purpose : This method serializes the object and
     * stores that object in to the file.
     *
     */

    public void serialize() {
        //creting a new FileReader.
        try {
            FileReader f = new FileReader("movie-matrix.txt");
            createMatrix(f);//creating matrix.
            //  h.readFile();
        } //File not found exception.
        catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
        //h.displayMatrix();
        try {
            FileOutputStream f1 = new FileOutputStream("movie-matrix2.ser");
            ObjectOutputStream out  = new ObjectOutputStream(f1);
            out.writeObject(this);
            System.out.println("Created Serializable file");
            out.close();
            f1.close();
        } //File not found exception.
        catch (FileNotFoundException ex) {
            System.out.println("File specified is not found." + ex);
        } //catching IO exception 
        catch (IOException ex) {
            System.out.println("IO exception" + ex);
        }
    }

    /**
     * ******************
     * Method : main(Driver).
     *
     * Purpose : This is the driver of the program.
     *
     */
    
   /*   public static void main(String[] args)  {
        // TODO code application logic here
        Hw4a h = new Hw4a();
        h.readFile();//calling readFile.
        h.serialize();//calling serialize.
    }*/
}
