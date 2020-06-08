import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ReviewSortMore more = new ReviewSortMore();
        int[] array = new int[] {9,7,0,5,4,99,1,4,2,3,10,100,-1};
        //more.slelteSort(array);
        //more.heapSort(array);
        //more.quickSort(array);
        more.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
