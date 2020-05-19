import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
         val = x;
     }
 }

class TreeDeal {
    //合并二叉树
        TreeNode newNode = null;
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

            return myMergeTrees(newNode, t1, t2);

        }
        public TreeNode myMergeTrees(TreeNode newNode, TreeNode t1, TreeNode t2) {
            if(t1 == null && t2 == null) {
                return null;
            }
            if(t1 != null && t2 != null) {
                TreeNode node = new TreeNode(t1.val + t2.val);
                newNode = node;
            }
            if(t1 != null && t2 == null) {
                t2 = new TreeNode(0);
                newNode = t1;
            }
            if(t1 == null && t2 != null) {
                t1 = new TreeNode(0);
                newNode = t2;
            }
            newNode.left = myMergeTrees(newNode.left, t1.left, t2.left);
            newNode.right = myMergeTrees(newNode.right, t1.right, t2.right);
            return newNode;
        }
    //非递归实现先序遍历链表返回
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
    //非递归实现中序遍历链表返回
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.empty()) {
                break;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list;
    }
    //非递归实现后序遍历链表返回
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(true) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.empty()) {
                break;
            }
            TreeNode node = stack.peek();
            if(node.right == null || node.right == prev) {
                list.add(node.val);
                stack.pop();
                prev = node;
            }else {
                cur = node.right;
            }
        }
        return list;
    }
}

public class MYWork {
    public static void main(String[] args) {

    }
}
