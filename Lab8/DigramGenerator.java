package Lab8;

import java.io.*;
import java.util.*;

/** class that implements WordGenerator.
 * @author Ben Stacey
 */
public class DigramGenerator implements WordGenerator {
    /** Random data field.*/
    private Random random;
    /** String used to add all the first letters to.*/
    private static String firstLetter = "";
    /** limit of the array.*/
    private static final int LIMIT = 26;
    /** Initialising the array.*/
    private static String[] w = new String[LIMIT];

    /** Constructor.
     *  @param r  
     */
    public DigramGenerator(Random r) {
        random = r;

        w = continuations();

        firstLetter = firstLetters();
    }

    /** continuations method adds all the additional letters to the array.
     *  @return w  
     */
    public static String[] continuations(){
        try{
            File file = new File("continuations.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < w.length; i++){
                w[i] = scan.nextLine();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.out.println("File not found");
        }
        return w;
    }

    /** adds all the first letters to a string.
     *  @return firstLetter
     */
    public static String firstLetters(){
        try {
            File file = new File("first-letters.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                firstLetter += scan.next();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.out.println("File not found");
        }
        return firstLetter;
    }

    /** gets the first letter.
     *  @return the first letter at a random index
     */
    public char first(){
        return firstLetter.charAt(random.nextInt(firstLetter.length()));   
    }

    /** Gets the next continuation.
     *  @return the conitunations from the array
     *  @param c  
     */
    public char next(char c){
        int index = c - 'a';
        int x = random.nextInt(w[index].length());
        return w[index].charAt(x);
    }

    /** nextWord builds up the result string.
     *  @return the builts string using the string builder
     *  @param n  
     */
    @Override
    public String nextWord(int n) {
        StringBuilder strb = new StringBuilder();
        char c =  first();
        strb.append(c);
        
        for(int i = 1; i < n; i++){
            c = next(c);
            strb.append(c);
        }
        
        return strb.toString();
    }
}
