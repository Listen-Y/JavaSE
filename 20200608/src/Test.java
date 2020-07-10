public class Test {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.add(9);
        queue.add(8);
        queue.add(7);
       /* while (!queue.isEmpty()) {
            System.out.print(queue.poll()+ " ");
        }*/
        queue.add(6);
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll()+ " ");
        }

    }
}
