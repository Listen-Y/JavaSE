import java.util.Arrays;

class HeapTest {
    //堆的向下调整
    public static void shiftDown(int[] array, int size, int index) {
        int patent = index;
        int child = 2 * patent + 1;
        while (child < size) {
            if(child + 1 < size && array[child + 1] > array[child]) {//取俩个结点的最大值
                child += 1;
            }
            if(array[child] > array[patent]) {//孩子的值大于parent的值
                int temp = array[child];
                array[child] = array[patent];
                array[patent] = temp;
            }else  {
                break;
            }
            patent = child;
            child = 2 * patent + 1;
        }
    }
    //向上调整
    public static void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child - 1)/2;
        while (child > 0) {
            if(array[child] > array[parent]) {//孩子的值大于parent的值
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1)/2;
        }
    }

    public static void main(String[] args) {

        //反例3 7 4 8 3 2 9
        //建大堆的时候向下调整如果后面出现最大的数字会出现反例
        //建小堆的时候向下调整若果后面出现最小的数字也会出现反例
        //而向上调整是不会出现反例的，所以在数组建堆的时候建议使用向上调整
        //注意，向下调整遍历数组一定是从前到后，因为index就是他的根结点
        //向上调整遍历数组要从后到前，因为index是最后一个叶子结点
        int[] array = new int[] {9,5,2,7,3,6,8};
        for (int i = 0; i < array.length; i++) {
            shiftDown(array, array.length, i);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("=============");
        int[] array1 = new int[] {9,5,2,7,3,6,8};
        for (int i = array1.length - 1; i >= 0; i --) {
            shiftUp(array1, array1.length ,i);
        }
        System.out.println(Arrays.toString(array1));
    }
}
