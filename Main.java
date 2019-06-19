/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #5                                           *****
 *****                                               Program #1                                                  *****
 *****___________________________________________________________________________________________________________*****
 *****                       1. Create a solution to the Missionaries and Cannibals problem.                     *****
 *****                         If a solution is found, output it using an ArrayList<String>                      *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import java.util.ArrayList;


public class Main {

    // CLASS VARIABLE(s) declaration(s)
    private static ArrayList<String> list = new ArrayList<>();


    public static void main(String[] args) {

        // Print the result of the solve() method call to the console
        System.out.println(solve(3, 3, 0, 0, 0, 0, 0));
        // Print out the ArrayList that contains the moves needed to solve the problem
        System.out.println(list);
    }


    // Method to solve the "Missionaries and Cannibals" problem
    private static boolean solve(int a, int b, int c, int d, int e, int f, int g){

        // Found the solution
        if( (e == 3) && (f == 3) && (a == 0) && (b == 0) && (c == 0) && (d == 0) && (g == 1) ){
            list.add(""+a+b+c+d+e+f);
            return true;
        }

        // More Cannibals on a shore than Missionaries. The Cannibal(s) ate the Missionary/Missionaries
            // Failure, return false
        else if( ((a < b) && (a != 0)) || ((e < f) && (e != 0)) ) return false;

        // One of our "Missionary" or "Cannibal" values or "number of Missionaries on the boat" or
            // "number of Cannibals on the boat" values is out of bounds, return false
        else if( ((a > 3 || a < 0)) || ((b > 3) || (b < 0)) || ((e > 3) || (e < 0)) ||
                ((f > 3) || (f < 0)) || ((c > 2) || (c < 0)) || ((d < 0) || (d > 2)) ) return false;

        // Too many people on the boat, return false
        else if( ((c + d) > 2) ) return false;

        // No one in boat to row it back to the other side
        else if((g == 1) && ((c+d) < 1)) return false;

        // Otherwise, try all the possible solutions, one at a time, until one leads to a solution
        else {
            // Different moves we can try when "g = 1"
            if (solve(a - 2, b, c + 2, d, e, f, 0)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
            if (solve(a, b - 2, c, d + 2, e, f, 0)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
            if (solve(a - 1, b - 1, c + 1, d + 1, e, f, 0)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
            if (solve(a - 1, b, c + 1, d, e, f, 0)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
            if (solve(a, b - 1, c, d + 1, e, f, 0)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }


            // Different moves we can try when "g = 0"
            if (solve(a, b, c - 2, d, e + 2, f, 1)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
            if (solve(a, b, c, d - 2, e, f + 2, 1)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
            if (solve(a, b, c - 1, d - 1, e + 1, f + 1, 1)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
            if (solve(a, b, c - 1, d, e + 1, f, 1)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
            if (solve(a, b, c, d - 1, e, f + 1, 1)) {
                list.add("" + a + b + c + d + e + f);
                return true;
            }
        }

        // Solution not found, return false
        return false;
    }
}
