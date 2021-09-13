package week11;                                                           
                                                                         
/**                                                                         
 * Selection sort.                                                        
 *@author Ben Stacey                                                       
 */                                                                       
public class HeapSort extends Sorter{                               

    /**                                                                   
     *Creates a new Selection sorter with the given integers to sort.       
     *@param nums                                                         
     */                                                                   
    public HeapSort(Integer[] nums){                                   
        super(nums);                                                  
    }
    
    /**                                                                   
     *Sort the integers.                                                    
     */                                                              
    public void sortNums(){                                                
        comparisons = 0;
        build(nums);
        Integer[] heap = new Integer[nums.length];
        for(i = nums.length-1; i >= 0; i--){
            heap[i] = nums[0];
            nums[0] = 0;
            build(nums);
            update();
        }
        nums = heap;
    }

    /**
     *build method.
     *@param heap is heap built          
     */
    public void build(Integer[] heap){
        for(j = (heap.length-2)/2; j >= 0; j--){
            max(heap,j);
        }
    }

    /**
     * max method.
     * @param heap     
     * @param i     
     */
    public void max(Integer[] heap, int i){
        if(hasChild(heap,i)){
            int max = heap[i];
            int bigChild;
            int temp = 0;
            if(hasChildren(heap, i)){
                if(heap[2 * i + 1] > heap[2 * i + 2]){
                    bigChild = 2 * i + 1;
                }else{
                    bigChild = 2 * i + 2;
                }
            }else{
                bigChild = 2 * i + 1;
            }
            if(max < heap[bigChild]){
                comparisons++;
                temp =  heap[bigChild];
                heap[bigChild] = heap[i];
                heap[i] = temp;
            }
            if(max != i){
                max(heap, bigChild);
            }
            update();
        }
    }

    /**
     * hasChild method.
     * @param heap  
     * @param i   
     * @return true       
     */
    public boolean hasChild(Integer[] heap, int i){
        try{
            int temp = heap[2 * i + 1];
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    /**
     * hasChildren method.
     * @param heap   
     * @param i   
     * @return true    
     */
    public boolean hasChildren(Integer[] heap, int i){
        try{
            int temp = heap[2 * i + 2];
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
}
