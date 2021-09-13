package Lab11;

/**
 *Quick Sort.
 *@author Ben Stacey
 */

public class QuickSort extends Sorter{

    /**
     * Creates a new Quick sorter with the given intgers to sort.
     *@param nums  
     */
    public QuickSort(Integer[] nums){
        super(nums);
    }

    /**
     * sortNums method.
     */
    @Override
    public void sortNums(){
        quickSort(0, nums.length -1);
    }

    /**
     * quickSort method.
     *@param left  
     * @param right  
    */
    public void quickSort(int left, int right){
        if(left < right){
            int p = partition(left, right);
            quickSort(left, p);
            quickSort(p + 1, right);
        }
    }

    /**
     *partition method.
     *@param right  
     *@param left    
     *@return hole           
     */
    public int partition(int left, int right){
        int pivot = nums[left];
        int hole = left;
        int i = left + 1;
        int j = right;
        while(0 == 0){
            while(j > hole && nums[j] >= pivot){
                j--;
                comparisons++;
                update();
            }

            if(j == hole){
                
                comparisons++;
                update();
                break;
            }

            nums[hole] = nums[j];
            hole = j;

            while(i < hole && nums[i] < pivot){
                i++;
                comparisons++;
                update();
                break;
              
            }

            if(i == hole){
                
                comparisons++;
                update();
                break;
                
            }

            
            nums[hole] = nums[i];
            hole = i;

            comparisons++;
            update();
        }

       

        nums[hole] = pivot;
        return hole;

        
    }
}
