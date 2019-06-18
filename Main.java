/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #5                                           *****
 *****                                               Program #1                                                  *****
 *****___________________________________________________________________________________________________________*****
 *****         1.Implement a solution to the Missionaries and Cannibals problem as described in the notes.       *****
 *****              Your solution must not only find if a solution exists, but if a solution is found,           *****
 *****                      output it using an ArrayList<String> (also described in the notes).                  *****                                                                              *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                                                                                           *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import java.util.ArrayList;


public class Main {

    // CLASS VARIABLE(s) declaration(s)
    private static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<String> tried = new ArrayList<>(); // <-- for Water Jugs problem


    public static void main(String[] args) {


        System.out.println(solve(3, 3, 0, 0, 0, 0, 0));
    }


    private static boolean solve(int a, int b, int c, int d, int e, int f, int g){

        // Found the solution
        if( (e == 3) && (f == 3) && (a == 0) && (b == 0) && (c == 0) && (d == 0) && (g == 0) ) return true;

        // More Cannibals on a shore than Missionaries. The Cannibal(s) ate the Missionary/Missionaries
            // Failure, return false
        else if( ((a < b) && (a != 0)) || ((e < f) && (e != 0)) ) return false;

        // One of our "Missionary" or "Cannibal" values or "number of Missionaries on the boat" or
            // "number of Cannibals on the boat" values is out of bounds, return false
        else if( ((a > 3 || a < 0)) || ((b > 3) || (b < 0)) || ((e > 3) || (e < 0)) ||
                ((f > 3) || (f < 0)) || ((c > 2) || (c < 0)) || ((d < 0) || (d > 2)) ) return false;

        // Too many people on the boat, return false
        else if( ((c + d) > 2) ) return false;

        // Otherwise, try all the possible solutions, one at a time, until one leads to a solution
        else{

            // Different moves we can try when "g = 1"
            if(solve(a-2, b, c+2, d, e, f, 0)) return true;
            if(solve(a, b-2, c, d+2, e, f, 0)) return true;
            if(solve(a-1, b-1, c+1, d+1, e, f, 0)) return true;
            if(solve(a-1, b, c+1, d, e, f, 0)) return true;
            if(solve(a, b-1, c, d+1, e, f, 0)) return true;


            // Different moves we can try when "g = 0"
            if(solve(a, b, c-2, d, e+2, f, 1)) return true;
            if(solve(a, b, c, d-2, e, f+2, 1)) return true;
            if(solve(a, b, c-1, d-1, e+1, f+1, 1)) return true;
            if(solve(a, b, c-1, d, e+1, f, 1)) return true;
            if(solve(a, b, c, d-1, e, f+1, 1)) return true;
        }

        return false;
    }



    // Set of code to determine if there is a solution to the Water Jugs problem and print the solution out (backwards).
        // Solution: Try to get 2 gallons into the 4-gallon jug
            // "x" = 4 gallon jug
            // "y" = 3 gallon jug
    // POWERPOINT: CHAPTER 18, SLIDES #30-33
    public static boolean jugs(int x, int y) {
        boolean temp;

        // if the ArrayList "tried" contains "0, 0", return "false"
        if(tried.contains(""+x+y)) return false;
        else tried.add(""+x+y);

        // "Border Conditions"
        if(x<0||x>4||y<0||y>3) return false;

        // if "x" equals 2, we solved the problem and return "true"
        else if(x==2) return true;

        // Otherwise, try all the possible solutions, one at a time, until one leads to a solution
        else  {
            // Call jugs with "x, 0" (empty out the 3-gallon jug)
            temp=jugs(x,0);

            // if any of the following jugs() calls equals "true", do not bother testing anymore,
                // return "true" and be done
            // Pour out the 4-gallon jug
            if(!temp) temp=jugs(0,y);
            if(!temp) temp=jugs(4,y);
            if(!temp) temp=jugs(x,3);
            if(!temp) temp=jugs(x+y,0);
            if(!temp) temp=jugs(0,x+y);
            if(!temp) temp=jugs(x-(3-y),3);
            if(!temp) temp=jugs(4,y-(4-x));

            // Outputs the states we went through to find a solution
            // NOTE: THIS OUTPUTS THE STATES BACKWARDS
            if(temp) System.out.println(""+x+" "+y);
        }
        // if every single test was false, return "false". If any of the tests were true, return "true"
        return temp;
    }
}
