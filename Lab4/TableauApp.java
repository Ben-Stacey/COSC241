package Lab4;

import java.util.Arrays;
/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Ben Stacey
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        return rowLengthsDecrease(t) && rowValuesIncrease(t)
            &&  columnValuesIncrease(t)
            && isSetOf1toN(t);
    }
    /**
     *  Returns a string representation of an array based tableau.
     *  @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][]t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Tests if the length of the rows are decreasing.
     * @param t is the value
     * @return returns a boolean.
     */
    public static boolean rowLengthsDecrease(int[][]t){
        boolean b = true;

        for(int x = 0; x < t.length - 1;x++){
            if(t[x].length < t[x+1].length){
                b = false;
            }

            
        }
        return b;       
    }

    /**
     * Checks is the values are decreasing.
     * @param t is the value
     * @return boolean value.
     */
    public static boolean rowValuesIncrease(int[][]t){
        boolean b = true;

        for(int x = 0; x < t.length - 1; x++){
            for(int j = 0; j < t[x].length - 1;j++){
                if(t[x][j] > t[x][j+1]){
                    b = false;
                }
            }
        }
        return b;
    }
    /**
     * Checks if the values are increasing in the columns.
     * @param t is the value
     * @return a boolean value.
     */
    public static boolean columnValuesIncrease(int[][]t){
        boolean b = true;

        for(int x = t.length-1; x > 0; x--){
            for(int j = 0; j < t[x].length;j++){
                if(t[x][j] < t[x-1][j]){
                    b = false;
                }
            }
        }
        return b;
    }

    /**
     * Checks if all the values are increasing and not missing.
     * @param t is the value
     * @return returns a boolean value. 
     */
    public static boolean isSetOf1toN(int[][]t){
        boolean b = true;
        int a = 0;
        int count = 0;
        
        for(int i = 0; i<t.length; i++){
            for(int j = 0; j<t[i].length;j++){
                count++;
            }
        }
        
        int y[] = new int[count];

        for(int[] e: t){
            for(int e1 : e){
                y[a++] = e1;
            }
        }

        Arrays.sort(y);

       
        for(int z = 1; z < count; z++){
            if(y[z - 1] != z){
                return false;
            }
        }
        return b;
    }
}

