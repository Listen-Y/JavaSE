import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //while (scan.hasNext()) {
        String s = scan.nextLine();
        String[] ss = s.split(" ");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < ss.length - 1; i++) {
            queue.add(Integer.parseInt(ss[i]));
        }
        for (int i = 0; i < Integer.parseInt(ss[ss.length - 1]); i++) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
        //}
    }
}

