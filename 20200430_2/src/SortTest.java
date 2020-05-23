import java.util.Arrays;

public class SortTest {
    //升序的直接插入排序
    public static void inUpSort(int[] array) {
        for(int index = 1; index < array.length; index ++) {
            int key = array[index];
            for (int prevIndex = index - 1; prevIndex >= 0 ; prevIndex--) {
                if(array[prevIndex] > key) {
                    array[prevIndex + 1] = array[prevIndex];
                    array[prevIndex] = key;
                }else {
                    //array[prevIndex + 1] = key;
                    break;
                }
            }
            //array[prevIndex + 1] = tmp;
        }
    }

    //升序希尔排序
    public static void shellUpSort(int[] array) {
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int index = gap; index < array.length; index += gap) {
                int key = array[index];
                for (int prevIndex = index - gap; prevIndex >= 0; prevIndex -= gap) {
                    if (array[prevIndex] > key) {
                        array[prevIndex + gap] = array[prevIndex];
                        array[prevIndex] = key;
                    } else {
                        break;
                    }
                }
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        /*int[] array = new int[] {3,5,2,6,9,7,4,8,96,1,19,61};
        inUpSort(array);
        System.out.println(Arrays.toString(array));*/
        int[] array1 = new int[] {9,8,7,6,5,4,3,2,1,0,-1};
        shellUpSort(array1);
        System.out.println(Arrays.toString(array1));
    }
}
