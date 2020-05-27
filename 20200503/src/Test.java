public class Test {
    public static void main(String[] args) {
        PriorityQueueForTopK topk = new PriorityQueueForTopK(3);
        int[] nums = new int[] {11,22,33,12,45,101,76,89,65,1,2,3,4,5,6,102,7,8,9,0,99,13,88,21,17,100};
        for (int i : nums
             ) {
            topk.offer(i);
        }
        System.out.println(topk.peek());
        while (!topk.empty()) {
            System.out.print(topk.poll() + " ");
        }
    }
}
