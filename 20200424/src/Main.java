import java.util.Scanner;

/**
 * 编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
 * 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
 * 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
 */
class Node {
    public char val;
    public Node left;
    public Node right;
    public Node (char val) {
        this.val = val;
    }
}

public class Main {
    private static int index;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            index = 0;
            String str = sc.next();
            Node root = buileTree(str);
            moddleTree(root);
            System.out.println();
        }
    }

    private static void moddleTree(Node root) {
        if(root == null) {
            return;
        }
        moddleTree(root.left);
        System.out.print(root.val + " ");
        moddleTree(root.right);
    }

    public static Node buileTree(String str) {
        if(index >= str.length()) {
            return null;
        }
        if(str.charAt(index) == '#') {
            return null;
        }
        Node cur = new Node(str.charAt(index));
        index ++;
        cur.left = buileTree(str);
        index ++;
        cur.right = buileTree(str);
        return cur;
    }
}