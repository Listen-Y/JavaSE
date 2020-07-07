import java.util.Scanner;
import java.util.Stack;

public class Main {
        public static int count;
        public static int[] array;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextByte();
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scan.nextInt();
            }
            func(40, n - 1);
            System.out.println(count);
        }
    }

    private static void func(int sum, int n) {
        if (sum == 0) {
            count++;
            return;
        }
        if (sum < 0 || n < 0) {
            return;
        }
        func(sum - array[n], n - 1);
        func(sum, n - 1);
    }


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        int ret = stack2.pop();
        while (!stack2.empty()) {
            int tmp = stack2.pop();
            stack1.push(tmp);
        }
        return ret;
    }
}
