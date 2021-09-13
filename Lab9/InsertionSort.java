package Lab9;

/**
 * Insertion sort.
 *@author Ben Stacey
 */
public class InsertionSort extends Sorter{

    /**
     *Creates a new Selection sorter with the given integers to sort.
     *@param nums  
     */
    public InsertionSort(Integer[] nums){
        super(nums);
    }

    /**
     *Sort the integers.
     */
    @Override
    public void sortNums(){
        Integer key = 0;
        for(i = 1; i < nums.length; i++){
            key = nums[i];
            for(j = i - 1; j >= 0; j--){
                if(nums[j] > key){
                    nums[j + 1] = nums[j];
                    nums[j] = key;
                }
                comparisons++;
                update();
            }
        }
    }
}
