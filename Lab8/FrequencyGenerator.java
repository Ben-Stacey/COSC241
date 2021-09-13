package Lab8;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/** class that implements WordGenerator.
 * @author Ben Stacey
 */
public class FrequencyGenerator implements WordGenerator {
    /**random datafield.*/
    private Random random;
    /** limit data field which is used to for the size of the array.*/
    private static final int LIMIT= 26;
    /** declares the array.*/
    private static Double[] w = new Double[LIMIT];


    /** constructor.
     *  @param r  
     */
    public FrequencyGenerator(Random r) {
        random = r;

        w = weights();
    }

    /** weights method puts the elements from the file into an array.
     * @return w  
     */
    public static Double[] weights(){
        try{
            File file = new File("letter-frequencies.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < w.length; i++){
                w[i] = scan.nextDouble();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
            System.out.println("File not found");
        }
        return w;
    }

    /** chooseIndex method.
     * @param w   
     * @return i  
     */
    public int chooseIndex(Double[] w){
        int i = 0;
        //random = new Random();
        double rand = random.nextDouble();
        while(rand > w[i]){
            rand -= w[i];
            i++;
        }
        return i;
    }

    /** nextWord method which build up a string of the words created.
     * @param n   
     * @return stre.toString()
     */
    @Override
    public String nextWord(int n) {
        StringBuilder strb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            char c = (char) ('a' + chooseIndex(w));
            strb.append(c);
        }
        
        return strb.toString();
    }
}
