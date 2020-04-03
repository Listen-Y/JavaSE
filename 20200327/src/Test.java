/**
 *
 * 单链表练习题
 */
public class Test {
    public static void main(String[] args) {
        LinkList link = new LinkList();
        link.addLast(60);
        link.addLast(20);
        link.addLast(50);
        link.addLast(40);
        link.addLast(30);
        link.display();
        Node ret = link.reserveLinkList();
        link.display2(ret);
      /*  System.out.println(link.returnMidNode().date);
        link.addLast(10);
        link.display();
        System.out.println(link.returnMidNode().date);
        System.out.println(link.returnNode_K(1).date);
        System.out.println(link.returnNode_K(6).date);
        //System.out.println(link.returnNode_K(7).date);
        link.display2(link.partition(50));*/

    }
}
