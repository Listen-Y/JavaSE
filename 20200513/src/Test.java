public class Test {

    public static void prevOrder(ReviewBinarySearchTree.Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.key + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    public static void inOrder(ReviewBinarySearchTree.Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,9,3,7,6,1,2};
        ReviewBinarySearchTree tree = new ReviewBinarySearchTree();
        for (int x : nums
             ) {
            tree.insert(x, 10);
        }
        System.out.println(tree.search(5));
        System.out.println(tree.search(2));
        System.out.println(tree.search(10));
        prevOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println("================");
        tree.delete(2);
        tree.delete(7);
        tree.delete(5);
        tree.delete(3);
        prevOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
    }
}
