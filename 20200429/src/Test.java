import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

    static class comp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
            //return o2 - o1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new comp());
        int[] nums = new int[]{3, 7, 4, 8, 3, 2, 9};
        for (int i : nums
        ) {
            pq.offer(i);
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}

   /* public static void main1(String[] args) {
        MyPriorQueue priQ = new MyPriorQueue();
        System.out.println(priQ.empty());
        int[] nums = new int[] {3, 7, 4, 8, 3, 2, 9};
        for (int i:nums
             ) {
            priQ.offer(i);
        }
        System.out.println(priQ.peek());
        while (!priQ.empty()) {
            System.out.print(priQ.poll() + " ");
        }
    }
}*/
