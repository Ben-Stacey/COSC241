package week02;


import java.util.Random;
/** week 1, 13/3/2021.
    @author Ben Stacey*/
public class Coins{
    /** data field. */
    public static final boolean HEADS = true;
    /** data field. */
    public static final boolean TAILS = false;
    /** data field. */
    private boolean[] coins;
    
    /** main method and this runs the class.
        @param args     
     */
    public static void main(String[] args){
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        System.out.println(c.countHeads());
    }

    /**creates a coins object from a string.
       @param c   
     */
    public Coins(String c){
        coins = new boolean[c.length()];
        for(int  i = 0; i < c.length(); i++){
            if(c.charAt(i) == 'T'){
                coins[i] = TAILS;
            } else if(c.charAt(i) == 'H'){
                coins[i] = HEADS;
            }
        }
    }

    /**constructs a coins object consisting of a series of length coins.
       @param length     
    */
    public Coins(int length){
        coins = new boolean[length];
        Random rand = new Random();
        for(int i = 0; i < length; i++){
            int r = rand.nextInt(2);
            if(r == 0){
                coins[i] = HEADS;
            }else{
                coins[i] = TAILS;
            }
        }
    }

    /**Returns an int which is the number of runs in this sequence of coins.
       @return x + 1
     */
    public int countRuns(){
        int x = 0;
        for(int i = 0; i < coins.length - 1; i++){
            if(coins[i] != coins[i + 1]){
                x++;
            }
        }
        return x + 1;
    }

    /**constuctor that sets coins to coins.
       @param coins      
    */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    /**returns an int which is the number of occurences of "heads".
       @return h
    */
    public int countHeads(){
        int h = 0;
        for(boolean x:coins){
            if(x == HEADS){
                h++;
            }
        }
        return h; 
    }

    /**method representation of the coin tosses.
       @return s
     */
    public  String toString(){
        String s = "";
        for(int i = 0; i < coins.length; i++){
            if(coins[i] == HEADS){
                s += 'H';
            }else if(coins[i] == TAILS){
                s += 'T';
            }
        }
        return s;
    }
}
