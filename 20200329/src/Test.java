/**
 *
 * 双向链表
 */
public class Test {
    public static void main(String[] args) {
        DoubleLinkList linkList = new DoubleLinkList();
        linkList.addFirst(10);
        linkList.addLast(100);
        linkList.addFirst(10);
        linkList.addLast(10);
        linkList.addLast(40);
        linkList.addIndex(0, 10);
        linkList.addIndex(6, 10);
        linkList.display();
        linkList.removeAllKey(10);
        linkList.display();
        linkList.clear();
        linkList.display();
        /*linkList.remove(-10);
        linkList.remove(50);
        linkList.remove(30);
        linkList.display();*/
    }
}
