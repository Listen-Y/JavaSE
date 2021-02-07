import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-25
 * Time: 14:25
 */
public class Demo {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
        Arrays.stream(nums).forEach(num -> {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        });
    }

/*    public void fun(List<Integer> list) {

    }

    public void fun(List<String> list) {

    }*/


}
