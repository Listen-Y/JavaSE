import java.util.*;
public class Main{
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
        //w的需要的体积,如果小于0就退出. 如果此时访问的下标为小于0了,但是需要的体积还是正数就也要退出
        if ((w > 0 && n < 0) || w < 0) {
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