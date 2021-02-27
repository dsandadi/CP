package hw4;

/**
 * ***************************************************************
 *
 * Course : CSCI 680-E Program : Assignment 4 Author : Dinesh Sandadi Z-number:
 * z1797942 Date Due : 05/05/2017 Purpose : This program reads the matrix
 * serializable file and calculates the correlation. . Execution: java Hw4b
 *
 ********************************************************************
 */
//importing libraries.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DINESH
 */
public class Hw4b {

//Data members.
    private Integer[][] matrix;
    ArrayList<Movies> movies;

    /**
     * ************
     * Method : getMatrix() method Purpose : This method returns the matrix.
     */
    public Integer[][] getMatrix() {
        return matrix;
    }
    private Hw4a d;

    /**
     * ************
     * Method : readFile() method Purpose : This method reads the serialiazable
     * file and displays the matrix results.
     */
    private void readFile() {
        try {
            FileInputStream fileIn = new FileInputStream("movie-matrix2.ser");//creting a new FileInputStream.
            ObjectInputStream in = new ObjectInputStream(fileIn);//crating a new ObjectInputStream.
            d = (Hw4a) in.readObject();
            d.displayMatrix();//displaying the matrix.
            in.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found" + ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IOException Or classNotFoundException :" + ex);
        }
    }

    /**
     * ************
     * Method : copyMatrix() method Purpose : This method copies the matrix in
     * to local objects data.
     */

    private void copyMatrix() {
        //creating the new Integer array.
        matrix = new Integer[d.getMatrix().size()][];
        //iterating through matrix.
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> a = d.getMatrix().get(i);
            matrix[i] = a.toArray(new Integer[a.size()]);//arrayList to array.
        }
    }

    /**
     * ****************
     * Method : average() method Purpose : This method calculates the average of
     * the given collection.
     *
     */

    private double average(ArrayList<Integer> a) {
        double sum = 0;
        //calculating the sum.
        for (Integer i : a) {
            sum += i;
        }
        return sum / a.size();
    }

    /**
     * ****************
     * Method : reviewers() method Purpose : This method returns the reviewers
     * of the given movies.
     *
     */
    private ArrayList<Integer> reviewers(int m1) {
        ArrayList<Integer> common = new ArrayList<Integer>();//creating a new arraylist.
        //adding the movie to the common arrayList. if positive.
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[m1 - 1][j] > 0) {
                common.add(j);
            }
        }
        return common;
    }

    /**
     * ****************
     * Method : std() method Purpose : This method calculates the standard
     * deviation of the given collection.
     *
     */

    private double std(ArrayList<Integer> a) {
        double avg = average(a);
        double sum = 0;
        //calculating the sum value.
        for (Integer i : a) {
            sum += Math.pow((i - avg), 2);
        }
        //returning the standard deviation.
        return Math.sqrt(sum / (a.size() - 1));
    }

    /**
     * ****************
     * Method : displayMatrix() method Purpose : This method displays the
     * matrix.
     *
     */
    public void displayMatrix() {
        //iterating through the matrix.
        for (Integer[] matrix1 : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * ****************
     * Method : getRatings() method Purpose : This method returns the ratings of
     * the given movie.
     *
     */
    private ArrayList<Integer> getRatings(ArrayList<Integer> m, int row) {
        ArrayList<Integer> a = new ArrayList<>();//creating a new arraylist.
        for (int i = 0; i < m.size(); i++) {
            a.add(matrix[row][m.get(i)]);//adding the rating to the list.
        }
        return a;//returning the list.
    }

    /**
     * ****************
     * Method : calcR() method Purpose : This method calculates the r value.
     *
     */
    private double calcR(ArrayList<Double> a, ArrayList<Double> b) {
        double[] product = new double[a.size()];//storing the products.
        double sum = 0;//storing the sum.
        for (int i = 0; i < a.size(); i++) {
            product[i] = a.get(i) * b.get(i);//calculating the product.
            sum += product[i];
        }
        //returning the r value.
        return sum / (a.size() - 1);

    }

    /**
     * ****************
     * Method : normalize() method Purpose : This method normalize the
     * arrayList.
     *
     */

    private ArrayList<Double> normalize(ArrayList<Integer> a) {
        double avg = average(a);//calculates the average.
        double std = std(a);//calculates the standard deviation.
        ArrayList<Double> normalized = new ArrayList<Double>();//creates the new arrayList.
        //for loop to calculate value and add them.
        for (int i = 0; i < a.size(); i++) {
            double value = (a.get(i) - avg) / std;
            normalized.add(value);
        }
        return normalized;
    }

    /**
     * ****************
     * Method : findCommon() method Purpose : This method finds the common
     * elements between two array lists.
     *
     */
    private ArrayList<Integer> findCommon(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> common = new ArrayList<>();//creating arraylist.
        int length = (a.size() < b.size() ? a.size() : b.size());
        //for loop to find common elements.
        for (int i = 0; i < length; i++) {
            if (a.contains(b.get(i)) && !(common.contains(b.get(i)))) {
                common.add(b.get(i));
            } else if (b.contains(a.get(i)) && !(common.contains(a.get(i)))) {
                common.add(a.get(i));
            }
        }
        return common;
    }

    /**
     * ****************
     * Method : printLine() method Purpose : This method displays the line.
     *
     */
    private void printLine() {
        for (int i = 0; i < 110; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * ****************
     * Method : displayResults() method Purpose : This method displays the
     * result.
     *
     */

    public void displayResults() {
        Collections.sort(movies, new MyComparator());//sorting the collectios.
        System.out.println("Final Results :");
        int count = 0;
        String r = "R";
        String n = "No.";
        String rev = "Reviews";
        String name = "Name";
        printLine();
        //formatting.
        System.out.printf("| %18s | %12s|%10s | %59s |\n", r, n, rev, name);
        printLine();
        // printing the values.
        for (Movies m1 : movies) {
            if (count < 20) {
                count++;
                System.out.printf("| %2d |%14.6f |%12d |%10s |%60s |\n", count, m1.rValue, m1.movieNumber, m1.reviewers, m1.movieName);
                printLine();
                // System.out.println("Movie Name :"+ m1.movieName);
                //System.out.println("Movie Number :"+ m1.movieNumber);
                //System.out.printf("r : %.6f"+m1.rValue);
            } else {
                break;
            }
        }
    }

    /**
     * ****************
     * MyComparator class to sort the movies based on the rValues.
     *
     */

    public class MyComparator implements Comparator<Movies> {

        //overriding the compare method.
        @Override
        public int compare(Movies o1, Movies o2) {
            if ((o2.rValue - o1.rValue) >= 0) {
                return 1;
            } else {
                return -1;
            }
        }

    }

    /**
     * *****************************************************************************
     * class name : Movies. author : DINESH SANDADI Purpose : This class has all
     * the movies with their attributes.
     *
     * *******************************************************************************
     */

    private class Movies {

        double rValue;//r value.
        int movieNumber;
        String movieName;
        int reviewers;

        //constructor.
        public Movies(int movieNumber, String movieName) {
            this.movieNumber = movieNumber;
            this.movieName = movieName;
        }

        //setter for rValue.
        public void setrValue(double rValue) {
            this.rValue = rValue;
        }

        //setting reviewers.
        public void setReviewers(int reviewers) {
            this.reviewers = reviewers;
        }

    }

    /**
     * ****************
     * Method : calculate() method Purpose : This method calculates the r
     * values.
     *
     */
    public void calculate() {

        readFile();//reads the file.
        copyMatrix();//copy the matrix.
        int movieNumber = 0;
        Scanner sc = new Scanner(System.in);
        movies = new ArrayList<>();
        //g.displayMatrix();
        //  System.out.println("*** No. of rows (movies)in matrix = " + getMatrix().length);
        // System.out.println("*** No. of columns (reviewers)in matrix = " + getMatrix()[0].length);
        //Interpreter starts from here.

        while (true) {
            movieNumber = 0;
            //movieNumber Validation.
            while ((movieNumber > getMatrix().length) || (movieNumber < 1)) {

                System.out.print("Movie number :");
                String m = sc.next();
                if (m.equals("q")) {
                    System.exit(0);
                }

                try {
                    movieNumber = Integer.parseInt(m);
                    if ((movieNumber > getMatrix().length) || (movieNumber < 1)) {
                        System.out.println("Movie number must be between 1 and 1682");
                    }

                } catch (Exception e) {
                    System.out.println("Invalid entry, try again");
                }
            }

            int count = 0;
            int compMovies = 0;
            boolean insuff = false;
            for (int i = 1; i < getMatrix().length; i++) {

                Movies m1 = new Movies(i, d.movies.get(i));//creating a new movie object.
                //  System.out.println("movie" + movieNumber + "compared with movie " + i);
                //            System.out.println("Total reviewers for movie 1 is " + reviewers(movieNumber).size());
                ArrayList<Integer> common = findCommon(reviewers(movieNumber), reviewers(i));//finds the common reviewers.

                //System.out.println("Common Reviewers are :" + common.size());
                m1.setReviewers(common.size());//sets the reviewer.
                // if insufficient
                if (common.size() < 10) {
                    //System.out.println("skipping movie " + i);
                    continue;
                }

                ArrayList<Integer> targetRatings = getRatings(common, movieNumber - 1);

                ArrayList<Integer> cmpRatings = getRatings(common, i - 1);
                count = 0;
                compMovies++;//increment cmpmovies.

                ArrayList<Double> tarNorm = normalize(targetRatings);//calculating the normalized values.
                ArrayList<Double> cmpNorm = normalize(cmpRatings);

                //System.out.printf("Target Average %.6f:\n", average(targetRatings));
                //System.out.printf("Target std %.6f:\n", std(targetRatings));
                //System.out.printf("Cmp std %.6f:\n", std(cmpRatings));
                //System.out.printf("Cmp Average :%.6f\n", average(cmpRatings));
                Double d = calcR(tarNorm, cmpNorm);

                //System.out.printf("r :%.6f\n", d);
                //System.out.println("Inserted :" + d);
                m1.setrValue(d);
                movies.add(m1);//adding movies to the movies arraylist.

            }

            //System.out.println("Compared Movies :" + compMovies);
            if (compMovies > 20) {
                displayResults();
            } else {
                System.out.println("Insufficient comparision movies");
            }
            movies.clear();
        }
    }

    /**
     * **
     *
     * Method :main() (Driver) Purpose:This is the driver of the program.
     *
     */

    public static void main(String[] args) {
        Hw4b g = new Hw4b();
        g.calculate();
    }
}
