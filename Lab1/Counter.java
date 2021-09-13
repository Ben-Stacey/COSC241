package week01;

import java.util.Scanner;
/** Lab 01, 5/3/21.
 * @author Ben Stacey
 */
public class Counter{
    /** main method and it counts the words and lines from user input.
     *  @param args 
     **/
    public static void main(String[]args){
        int word = 0;
        int line = 0;
        Scanner fileScan = new Scanner(System.in);
        while(fileScan.hasNextLine()){
            String inputLine = fileScan.nextLine();
            line++;
            Scanner scan = new Scanner(inputLine);
            while(scan.hasNext()){
                scan.next();
                word++;
            }
        }
    
        System.out.println("lines: " + line);
        System.out.println("words: " + word);
    }//end method
}//end class
