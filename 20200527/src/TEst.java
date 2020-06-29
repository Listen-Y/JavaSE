import java.util.Arrays;

public class TEst {
    public static void main(String[] args) {
        ReviewSort sort = new ReviewSort();
        int[] nums = new int[]{9,8,7,6,6,5,4,3,2,1};
        //sort.quickSort(nums);
        //sort.shellSort(nums);
        //sort.insertSort(nums);
        //sort.bubbleSort(nums);
        //sort.heapSort(nums);
        //sort.mergerSort(nums);
        //sort.selectSort(nums);
        //sort.quickSortByLoop(nums);
        sort.mergeSortByLoop(nums);
        System.out.println(Arrays.toString(nums));
    }
}
