package week11;

/**
 * Selection sort.
 *@author Ben Stacey
 */
public class SelectionSort extends Sorter{

    /**
     *Creates a new Selection sorter with the given integers to sort.
     *@param nums  
     */
    public SelectionSort(Integer[] nums){
        super(nums);
    }

    /**
     *Sort the integers.
     */
    public void sortNums(){
        for(i = 0; i < nums.length; i++){
            for(j = i; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                comparisons++;
                update();
            }
        }
    }
}
