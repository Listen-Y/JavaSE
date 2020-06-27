import java.util.Arrays;
import java.util.Scanner;

public class Test_2 {
    public static void main(String[] args) {
        int[] nums = new int[5];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(nums));
    }
}
