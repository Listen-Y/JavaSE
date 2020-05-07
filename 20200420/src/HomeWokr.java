class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
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

    //计算结点个数
    static int size = 0;
    public void getSize1(Node root) {
        if(root == null) {
            return;
        }
        size ++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    public int getSize2(Node root) {
        if(root == null) {
        return 0;
        }
        int count = 1;
        count += getSize2(root.left);
        count += getSize2(root.right);
        return count;
    }

    //子问题思路-求结点个数
    public int getSize3(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + getSize3(root.left) + getSize3(root.right);
    }

    //求叶子结点个数
    static int leafSize = 0;
    public void getLeafSize1(Node root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leafSize ++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    public int getLeafSize2(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root.left == null && root.right == null) {
            count ++;
        }
        count += getLeafSize2(root.left);
        count += getLeafSize2(root.right);
        return count;
    }

    public int getLeafSize3(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize3(root.left) + getLeafSize3(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    public int getKLevelSize(Node root, int k) {
        if(root == null) {
            return 0;
        }
        if(k < 1) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        int count = 0;
        count += getKLevelSize(root.left, k - 1);
        count += getKLevelSize(root.right, k -1);
        return count;
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    public Node find(Node root, char val) {
        if(root == null) {
            return  null;
        }
        if(root.val == val) {
            return root;
        }
        Node node = find(root.left, val);
        if(node != null) {
            return node;
        }
        return find(root.right, val);
    }

}

public class HomeWokr {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.build();
        System.out.println("===size===");
        tree.getSize1(root);
        System.out.println(Tree.size);
        System.out.println(tree.getSize2(root));
        System.out.println(tree.getSize3(root));
        System.out.println("===leafsize===");
        tree.getLeafSize1(root);
        System.out.println(Tree.leafSize);
        System.out.println(tree.getLeafSize2(root));
        System.out.println(tree.getLeafSize3(root));
        System.out.println("===K Node===");
        System.out.println(tree.getKLevelSize(root, 1));
        System.out.println(tree.getKLevelSize(root, 0));
        System.out.println(tree.getKLevelSize(root, 3));
        System.out.println(tree.getKLevelSize(root, 4));
        System.out.println("===find val===");
        System.out.println(tree.find(root, 'F'));

    }
}
