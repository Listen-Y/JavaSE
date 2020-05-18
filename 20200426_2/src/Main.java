import com.sun.webkit.graphics.WCFontCustomPlatformData;

import java.util.Arrays;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /
//  4
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
class Solution {
    private StringBuffer str = new StringBuffer();
    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        myTree2Str(t);
        str.delete(0,1);
        str.delete(str.length()- 1, str.length());
        return str.toString();
    }
    public void myTree2Str(TreeNode t) {
        if(t == null) {
            return;
        }
        str.append("(");
        str.append(String.valueOf(t.val));
        myTree2Str(t.left);
        if (t.left == null && t.right != null) {
            str.append("()");
        }
        myTree2Str(t.right);
        str.append(")");
    }

    private int[] array = new int[10];
    public int widthOfBinaryTree(TreeNode root) {
        Arrays.fill(array,0);
        myWidthOfBinaryTree(root, 0);
        Arrays.sort(array);
        return array[array.length - 1];
    }

    public void myWidthOfBinaryTree(TreeNode root, int index) {
        if(root == null) {
            return;
        }
        int i = array[index];
        array[index] = i + 1;
        myWidthOfBinaryTree(root.left, index + 1);
        myWidthOfBinaryTree(root.right, index + 1);
    }
}
public class Main {
    //非递归实现树的先序遍历
    public void prevOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }
    //非递归实现中序遍历
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            //一直往左走
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //
            if(stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val);
            cur = top.right;
        }
    }
    //后序遍历的非递归实现
    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.empty()) {
                break;
            }
            TreeNode top = stack.peek();
            if(top.right == null || top.right == prev) {
                System.out.print(top.val);
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }


        }
    }


    public static void main(String[] args) {

    }
}
