import java.util.Arrays;

/**
 * String System StringBuffer
 */
class Node {
    public char aChar;
    public Node next;

    public Node(char aChar) {
        this.aChar = aChar;
        this.next = null;
    }

    public Node() {

    }
}

class LinkList {
    private Node head;

    public LinkList() {
        this.head = null;
    }

    public void addFirst(char achar) {
        Node elem = new Node(achar);
        if(this.head == null) {
            this.head = elem;
            return;
        }
        elem.next = this.head;
        this.head = elem;

    }

    public void disPlay() {
        Node find = this.head;
        while (find != null) {
            System.out.print(find.aChar);
            find = find.next;
        }
        System.out.println();
    }
}

public class Test {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 5; i++) {
            linkList.addFirst('*');
            linkList.addFirst(' ');
        }
        linkList.disPlay();
        for (int i = 0; i < 5; i++) {
            linkList.addFirst(' ');
            linkList.disPlay();
        }
    }

    public static void main5(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("abcdef");
        stringBuffer.append('g');
        stringBuffer.insert(0, '0');
        stringBuffer.insert(stringBuffer.length(), 'h');
        System.out.println(stringBuffer);

    }

    public static void main4(String[] args) {
        String str1 = "aaa";
        String str2 = "aaa";//在字符串常量池
        String str3 = new String("aaa");
        String str4 = new String("aaa").intern();//主动进入字符串常量池
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
    }


    public static void main3(String[] args) {
        System.out.println(System.currentTimeMillis());
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(System.currentTimeMillis());
    }


    public static void main2(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};
        String str1 = "cdfdscdsfcda";
        System.out.println(String.valueOf(chars));//返回字符串
        System.out.println(String.valueOf(chars, 0, 2));
        System.out.println(Arrays.toString(str1.toCharArray()));

    }

    public static void main1(String[] args) {
        String str1 = "abcdef";
        String str2 = "a";
        System.out.println(String.format(str2, str1));
    }
}
