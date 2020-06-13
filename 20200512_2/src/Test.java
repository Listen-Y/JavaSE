
public class Test {

    public static void preOrder(BinarySearchTree.Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(BinarySearchTree.Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] array = new int[] {10,1,1,3,0,4,6,7,9};
        for (int i : array
             ) {
            System.out.println(tree.insert(i, 90));
        }
        preOrder(tree.root);
        //System.out.println();
        //inOrder(tree.root);
        //System.out.println(tree.search(8).key);
        tree.delete(6);
        tree.delete(10);
        tree.delete(3);
        tree.delete(9);
        System.out.println();
        preOrder(tree.root);
    }
}
