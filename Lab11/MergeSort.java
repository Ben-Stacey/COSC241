package Lab11;                                                         
                                                                     
/**                                                                       
 * Selection sort.                                                          
 *@author Ben Stacey                                                  
 */                                                                   
public class MergeSort extends Sorter{                          
                                                                           
    /**                                                                
     *Creates a new Selection sorter with the given integers to sort.    
     *@param nums                                                          
     */                                                               
    public MergeSort(Integer[] nums){                                
        super(nums);
    }                                                                
                                                                         
    /**                                                                    
     *Sort the integers.                                                  
     */                                                                 
    @Override
    public void sortNums(){                                          
        mergeSort(0, nums.length - 1);
    }

    /**
     *mergeSort method.
     *@param left          
     *@param right       
     */
    public void mergeSort(int left,int  right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid + 1, right);
        }
    }

    /**
     *merge method.
     *@param left          
     *@param mid         
     *@param right    
     */ 
    public void merge(int left,int mid,int right){
        Integer[] temp = nums.clone();
        i = left;
        j = left;
        int k = mid;
        while(i < mid && k <= right){
            if(temp[i] < temp[k]){
                nums[j++] = temp[i++];
                comparisons++;
                update();
            }else{
                nums[j++] = temp[k++];
                comparisons++;
                update();
            }
            comparisons++;
            update();
        }
        
        while(i < mid){
            nums[j++] = temp[i++];
            comparisons++;
            update();
        }

        while(j <= right){
            nums[j++] = temp[k++];
            comparisons++;
            update();
        }
        comparisons++;
        update();
    }
}
