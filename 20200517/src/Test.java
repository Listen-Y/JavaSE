public class Test {

    public static void prevOrder(ReviewBinarySearchTree.Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.key + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    public static void main(String[] args) {
        ReviewBinarySearchTree tree = new ReviewBinarySearchTree();
        int[] array = new int[] {5,3,7,1,9,6};
        for (int x : array
             ) {
            tree.put(x, 10);
        }
        System.out.println(tree.get(5));
        System.out.println(tree.get(7));
        System.out.println(tree.get(9));
        System.out.println(tree.get(1));
        System.out.println(tree.get(0));
        prevOrder(tree.head);
        System.out.println();
        System.out.println("===============");
        tree.remove(5);
        tree.remove(3);
        tree.remove(9);
        tree.remove(1);
        prevOrder(tree.head);
    }
}
