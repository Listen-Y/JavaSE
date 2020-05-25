import java.util.Arrays;

public class Sort {
    //降序直接插入排序
    public static void inDownSort(int[] array) {
        for (int index = 1; index < array.length; index++) {
            int tmp = array[index];
            for (int prevIndex = index - 1; prevIndex >= 0; prevIndex--) {
                //若要升序直接改为：tmp < array[prevIndex]
                if(tmp > array[prevIndex]) {
                    array[prevIndex + 1] = array[prevIndex];
                    array[prevIndex] = tmp;
                }else {
                    break;
                }
            }
        }
    }

    //降序希尔排序
    public static void shellDownSort(int[] array) {
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int index = gap; index < array.length; index++) {
                int tmp = array[index];
                for(int prevIndex = index - gap; prevIndex >= 0; prevIndex -= gap) {
                    //若要升序直接改为：tmp < array[prevIndex]
                    if(tmp > array[prevIndex]) {
                        array[prevIndex + gap] = array[prevIndex];
                        array[prevIndex] = tmp;
                    }else {
                        break;
                    }
                }
            }
            gap /= 2;
        }
    }

    //降序折半插入排序
    public static void bsInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int left = 0;
            int right = i;
            while (left < right) {
                int m = (left + right) / 2;
                //若要升序直接改为：v >= array[m]
                if (v <= array[m]) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }
            // 搬移
            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = v;
        }
    }

    //降序折半插入排序
    public static void inHalfDownSort(int[] array) {
        for (int index = 1; index < array.length; index++) {
            int tmp = array[index];
            int low = 0;
            int high = index;
            //与折半查找不同的是，折半查找这里是low<=high
            while (low < high) {
                int mid = (low + high) / 2;
                //若要升序直接改为：array[mid] <= tmp
                if(array[mid] >= tmp) {
                    low += mid + 1;
                }else {
                     high = mid;
                }
            }
            for (int i = index; i > low; i--) {
                array[i] = array[i - 1];
            }
            array[low] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {6,9,3,4,8};
        inDownSort(array);
        System.out.println(Arrays.toString(array));
        int[] array1 = new int[] {6,9,3,4,8};
        shellDownSort(array1);
        System.out.println(Arrays.toString(array1));
        int[] array2 = new int[] {6,9,3,4,8};
        bsInsertSort(array2);
        System.out.println(Arrays.toString(array2));
        int[] array3 = new int[] {6,9,3,4,8};
        inHalfDownSort(array3);
        System.out.println(Arrays.toString(array3));

    }
}
