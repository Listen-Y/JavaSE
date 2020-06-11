import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        SortByLoop loop = new SortByLoop();
        int[] array = new int[] {0,9,8,7,6,5,4,3,21,1};
        //loop.quickSortByLoop(array);
        loop.mergeSortBuLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
