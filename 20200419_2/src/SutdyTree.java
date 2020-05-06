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

    // 前序遍历
     void preOrderTraversal(Node root) {
         //节点为空结束方法
        if(root == null) {
            return;
        }
        //访问根节点对其进行操作
        System.out.print(root.val + " ");
        //访问根的左节点
        preOrderTraversal(root.left);
        //访问根的右节点
        preOrderTraversal(root.right);
     }
    // 中序遍历
     void inOrderTraversal(Node root) {
        //节点为空结束方法
        if(root == null) {
            return;
        }
         //访问根的左节点
        inOrderTraversal(root.left);
         //访问根节点对其进行操作
        System.out.print(root.val + " ");
         //访问根的右节点
        inOrderTraversal(root.right);
     }
    // 后序遍历
     void postOrderTraversal(Node root) {
         //节点为空结束方法
        if(root == null) {
            return;
        }
         //访问根的左节点
        postOrderTraversal(root.left);
         //访问根的右节点
        postOrderTraversal(root.right);
         //访问根节点对其进行操作
        System.out.print(root.val + " ");
     }
}

public class SutdyTree {

    /*public static void prevFindNode(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        for()
    }*/

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.build();
        //System.out.println(root);
        System.out.println("前序遍历");
        tree.preOrderTraversal(root);
        System.out.println();
        System.out.println("中序遍历");
        tree.inOrderTraversal(root);
        System.out.println();
        System.out.println("后序遍历");
        tree.postOrderTraversal(root);

    }
}
