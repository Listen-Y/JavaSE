public class Test {
    public static void main(String[] args) {
        MyLinkList link = new MyLinkList();
        link.addLast(10);
        link.addLast(20);
        link.addLast(30);
        link.addLast(40);
        link.addLast(50);
        link.addLast(60);
        link.display();
        link.display2(link.reserveLinkList());

    }
}
