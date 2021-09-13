package week03;                                                            
                                                                            
/**                                                                         
 *  A recursive representation of a tower of blocks.                        
 *                                                                          
 * @author Michael Albert                                                   
 */                                                                         
public class Tower{                                                         
                                                                            
    /** The top block. */                                                   
    private char top;                                                       
                                                                            
    /** The rest of the tower. */                                           
    private Tower rest;
                                                                            
    /**                                                                     
     * Creates a new empty Tower.                                           
     */                                                                     
    public Tower() {                                                        
        this.top = ' ';                                                     
        this.rest = null;                                                   
    }                                                                       
                                                                            
    /**                                                                     
     *  External classes can only create empty towers and manipulate        
     *  them using public methods, because this constructor is              
     *  private.                                                            
     * @param top the top block in this tower                               
     * @param rest the rest of the tower                                    
     */                                                                     
    private Tower(char top, Tower rest) {                                   
        this.top = top;                                                     
        this.rest = rest;                                                   
    }                                                                       
                                                                            
    /**                                                                     
     *  Returns true if this tower is empty, otherwise false.  Empty        
     *  towers are represented with the top block being a space             
     *  character.                                                          
     * @return whether the tower is empty or not.                           
     */                                                                     
    public boolean isEmpty() {                                              
        return top == ' ';                                                  
    }                                                                       
                                                                            
    /**                                                                     
     *  Creates a new tower by adding the given block to the top of         
     *  this tower.                                                         
     * @param block a block to add to the top of this tower.                
     * @return a new tower created by adding a block to the top of          
     * this tower.                                                          
     */                                                                     
    public Tower add(char block) {                                          
        return new Tower(block, this);                                     
    }
    /**
     * returns an int equal to the height.
     * @return 0 is a zero and 1 + this.rest.height
     */
    public int height(){
        if(this.isEmpty()){
            return 0;
        }
        return 1 + this.rest.height();
    }
    /**
     * returns an int equal to the number of blocks equal to c.
     *@return checking the given values
     *@param c char value
     */
    public int count(char c){
        if(this.isEmpty()){
            return 0;  
        }else if(this.top == c){
            return 1 + this.rest.count(c);
        }else{
            return 0 + this.rest.count(c);
        }
    }
}
