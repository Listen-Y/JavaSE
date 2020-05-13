import java.util.LinkedList;
import java.util.Queue;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

class Tree {

    public Node build () {
        Node node = new Node('A');
        Node node1 = new Node('B');
        Node node2 = new Node('C');
        Node node3 = new Node('D');
        Node node4 = new Node('E');
        Node node5 = new Node('G');
        Node node6 = new Node('F');
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node2.right = node6;
        return node;
    }

    // 层序遍历
    void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) {
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.val + " ");
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
        }
        System.out.println();
    }

    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(Node root) {
        if(root == null) {
            return true;
        }
        boolean isFirstStep = true;//为false表示第二阶段
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(isFirstStep) {
                if(cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left == null && cur.right != null) {
                    return false;
                }else if(cur.left != null && cur.right == null) {//左不为空 右为空
                    isFirstStep = false;
                    queue.offer(cur.left);
                }else {//左右都为空
                    isFirstStep = false;
                }
            }else {//第二阶段判断只要改结点有左或者右结点就说明不是完全二叉树
                if(cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class TreeTestDif {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.build();
        tree.levelOrderTraversal(root);
    }
}
