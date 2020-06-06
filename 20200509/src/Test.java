import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ReviewAllSort sort = new ReviewAllSort();
        int[] nums = new int[] {9,5,8,0,1,4,2,6,7,3};
        //sort.insertSort(nums);
        //sort.shellSort(nums);
        //sort.seleteSort(nums);
        //sort.heapSort(nums);
        //sort.bubbleSort(nums);
        //sort.quickSort(nums);
        //sort.quickSortByLoop(nums);
        //sort.mergeSort(nums);
        sort.mergeSortByLoop(nums);
        System.out.println(Arrays.toString(nums));
    }
}
