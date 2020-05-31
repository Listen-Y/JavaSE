import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * review 非递归实现遍历二叉树
 */
class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

class TreeDeal {
    public TreeNode bulidTree() {
        TreeNode node1 = new TreeNode(11);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(13);
        TreeNode node4 = new TreeNode(14);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(16);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node5.left = node6;
        return node1;
    }

    public void prevNode(TreeNode node) {
        if(node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            System.out.print(tmp.data + " ");
            if(tmp.right != null) {
                stack.push(tmp.right);
            }
            if(tmp.left != null) {
                stack.push(tmp.left);
            }
        }
    }

    public void midNode(TreeNode node) {
        if(node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = node;
        while (true) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            if(stack.isEmpty()) {
                break;
            }
            TreeNode node1 = stack.pop();
            System.out.print(node1.data + " ");
            tmp = node1.right;
        }
    }

    public void lastNode(TreeNode node) {
        if(node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = node;
        TreeNode prev = null;
        while (true) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            if(stack.isEmpty()) {
                break;
            }
            TreeNode node1 = stack.peek();
            if(node1.right == null || node1.right == prev) {
                System.out.print(node1.data + " ");
                stack.pop();
                prev = node1;
            }else {
                tmp = node1.right;
            }
        }
    }
}
public class Review {
    public static void main(String[] args) {
        TreeDeal deal = new TreeDeal();
        TreeNode root = deal.bulidTree();
        deal.prevNode(root);
        System.out.println();
        deal.midNode(root);
        System.out.println();
        deal.lastNode(root);
    }
}
