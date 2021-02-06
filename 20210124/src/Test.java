import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-24
 * Time: 17:21
 */
public class Test {

    public static void main(String[] args) {
 /*       Integer i = Integer.valueOf(2222);
        Integer ii = Integer.valueOf(2222);
        Integer iii = new Integer(2222);
        System.out.println(i.equals(ii));
        System.out.println(i.equals(iii));*/
        System.out.println(test());
    }

    public Test() {

    }

    private static int test() {
        int num = 0;
        try {
            num++;
            System.out.println("try"+ " " + num);
            return num;
        }catch (Exception e) {
            num++;
            System.out.println("catch"+ " " + num);
        } finally {
            num++;
            System.out.println("finally"+ " " + num);
        }
        System.out.println("last");
        return num;
    }

    /*    public void play(List<String> list) {

    }

    public void play(List<Integer> list) {

    }*/

    public int minNumberInRotateArray(int [] array) {

        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return array[low];
    }
}
