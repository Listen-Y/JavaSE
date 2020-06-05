import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ReviewSort sort = new ReviewSort();
        int[] nums = new int[] {8,6,4,7,2,0,1,10};
        //sort.checkSort(nums);
        //sort.heapSort(nums);
        //sort.bubbleSort(nums);
        //sort.bubbleSort1(nums);
        //sort.insertSort(nums);
        //sort.shellSort(nums);
        //sort.quickSort(nums);
        //sort.quickSortByLoop(nums);
        //sort.mergeSort(nums);
        //sort.mergeSortByLoop(nums);
        sort.betterQuickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
