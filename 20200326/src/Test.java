public class Test {
    public static void main(String[] args) {
        MyLinkList link = new MyLinkList();
        link.addFirst(10);
        link.addLast(20);
        link.addFirst(1);
        link.addLast(40);
        link.addIndex(3, 30);
        link.addIndex(0, 0);
        link.addIndex(6,50);
        link.addIndex(10, 100);
        link.display();
        System.out.println(link.size());
        if (link.contains(20)) {
            System.out.println("OK");
        }
        link.remove(0);
        link.remove(30);
        link.remove(50);
        link.display();
        link.clear();
        link.display();

        System.out.println("===============");
        MyLinkList link2 = new MyLinkList();
        int[] arr = new int[] {2,2,2,2,1,1,1,2,2,1,2,1,2,1,2,1,2,2,1,1,2,2,2,2,2};
        for (int i = 0; i < arr.length; i++) {
            link2.addIndex(i,arr[i]);
        }
        link2.display();
        link2.removeAllKey(2);
        link2.display();
    }
}
