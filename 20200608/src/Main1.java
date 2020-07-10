import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            if (n > 1000) {
                n = 999;
            }
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int count = 0;
            for (int i = 0; list.size() != 1; ) {
                if (count == 2) {
                    count = -1;
                    list.remove(i);
                } else {
                    i++;
                }
                count++;
                if (i == list.size()) {
                    i = 0;
                }
            }
            System.out.println(list.get(0));
        }
    }
}


 class Main2 {
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
