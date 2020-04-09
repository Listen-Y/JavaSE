public class Test {
    public static void main(String[] args) {
        FakeLinkListNode linkListNode = new FakeLinkListNode();
        linkListNode.addFirst("bbb");
        linkListNode.addFirst("aaa");
        linkListNode.addLast("ccc");
        linkListNode.addLast("ddd");
        linkListNode.addFirst("000");
        linkListNode.addIndex(0, "eee");
        linkListNode.addIndex(6, "ggg");
        linkListNode.addIndex(8, "fff");
        linkListNode.display();
        System.out.println(linkListNode.size());
        if (linkListNode.contains("000") && linkListNode.contains("ggg")) {
            System.out.println("OK");
        }
        System.out.println("=========removeFirstKey==========");
        linkListNode.display();
        linkListNode.remove("eee");
        linkListNode.remove("ggg");
        linkListNode.remove("bbb");
        linkListNode.remove("000");
        linkListNode.display();
        System.out.println("=========rremoveAllKey=========");
        linkListNode.addFirst("000");
        linkListNode.addFirst("000");
        linkListNode.addLast("000");
        linkListNode.addLast("000");
        linkListNode.addIndex(3, "000");
        linkListNode.addIndex(4, "000");
        linkListNode.addIndex(6, "000");
        linkListNode.display();
        linkListNode.removeAllKey("000");
        linkListNode.display();
        System.out.println("======clear=======");
        linkListNode.clear();
        linkListNode.display();
    }
}
