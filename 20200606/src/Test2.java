import java.util.*;
public class Test2{
    private static int count = 0;
    private static int[] nums;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scan.nextInt();
            }
            greedyFunc(40, n - 1);
            System.out.println(count);
        }
    }

    private static void greedyFunc(int w, int n) {
        if (w < 0) {
            return;
        }
        if (n < 0 && w > 0) {
            return;
        }
        if (w == 0) {
            count++;
            return;
        }
        greedyFunc(w - nums[n], n - 1);
        greedyFunc(w, n - 1);
    }
}