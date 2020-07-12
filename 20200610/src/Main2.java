import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int N = scan.nextInt();
            int num1 = 0;
            int num2 = 1;
            while (num2 < N) {
                int tmp = num1;
                num1 = num2;
                num2 += tmp;
            }
            int ret = Math.min(num2 - N, N - num1);
            System.out.println(ret);
        }
    }
}



class Robot {
    private int count;
    private int X;
    private int Y;
    public int countWays(int x, int y) {
        // write code here
        count = 0;
        X = x;
        Y = y;
        countWaysHelper(1, 1);
        return count;
    }
    private void countWaysHelper(int x, int y) {
        if (x == X && y == Y) {
            count++;
            return;
        }
        if (x > X || y > Y) {
            return;
        }
        countWaysHelper(x + 1, y);
        countWaysHelper(x, y + 1);
    }
}