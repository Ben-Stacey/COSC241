package week03;
/** week 3, Recursive work.
 *@author Ben Stacey
 */
public class RecursiveApp{
    /**returns a long equal to the number of digits of its arguement.
     *@param n is the parameter
     *@return total is the total
     */
    public static long digits(long n){
        if(n < 10){
            return 1;
        }
        return 1 + digits(n/10);
    }
    /** returns a long equal to the sum of the digits of n.
     *@param n is the parameter
     *@return total is the total
     */
    public static long sumOfDigits(long n){
        if(n == 0){
            return n;
        }else{
            return n % 10 + sumOfDigits(n/ 10);
        }
    }
}

