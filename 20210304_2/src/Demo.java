import java.util.*;

public class Demo {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>() ;
        stack.pop();
        PriorityQueue<String> queue = new PriorityQueue<>();


    }

    public static void main1(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        String s1 = "abcfbc";
        String s2 = "abfcab";
        System.out.println(fun(s1, s2));

        String m1 = "programming";
        String m2 = "contest";
        System.out.println(fun(m1, m2));

        String n1 = "abcd";
        String n2 = "mnp";
        System.out.println(fun(n1, n2));
    }

    public static void main2(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] arr = new int[] {1,0,2,3,0,4,5,0};
        fun2(arr);
        System.out.println(Arrays.toString(arr));
        int[] brr = new int[] {1,2,3};
        fun2(brr);
        System.out.println(Arrays.toString(brr));
    }


    /**
     * 0拷贝问题
     * @param arr
     */
    public static void fun(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) continue;
            for (int j = arr.length - 1; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            i++;
        }
    }

    public static void fun2(int[] arr) {
        if (arr == null) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                queue.offer(0);
                length--;
            }
            queue.offer(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
    }

    /**
     * dp
     * 字长连续子串
     * @param m
     * @param n
     * @return
     */

    public static int fun (String m, String n) {
        if (m == null || n == null) {
            return 0;
        }
        int lenM = m.length();
        int lenN = n.length();
        int[][] dp = new int[lenM + 1][lenN + 1];
        for (int i = 0; i <= lenN; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= lenM; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < lenM; i++) {
            for (int j = 0; j < lenN; j++) {
                char mChar = m.charAt(i);
                char nChar = n.charAt(j);
                if (mChar == nChar) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[lenM][lenN];
    }
}
