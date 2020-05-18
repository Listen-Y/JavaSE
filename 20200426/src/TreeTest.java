import java.util.Arrays;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }


//根据一棵树的前序遍历与中序遍历构造二叉树。
class Solution {
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return myBuildTree(preorder, inorder, 0, preorder.length);
    }
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int indexLeft, int indexRight) {
        if(indexLeft >= indexRight) {
            return null;
        }
        if(index >= inorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        index ++;
        int pos = findNodePos(inorder, node.val);
        node.left = myBuildTree(preorder, inorder, indexLeft, pos);
        node.right = myBuildTree(preorder, inorder, pos + 1, indexRight);
        return node;
    }

    private int findNodePos(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return  -1;
    }
}


//根据一棵树的中序遍历与后序遍历构造二叉树。
class Solution1 {
    private int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return myBuildTree(inorder, postorder, 0, postorder.length);
    }

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int indexLeft, int indexRight) {
        if(indexLeft >= indexRight) {
            return null;
        }
        if(index < 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[index]);
        index --;
        int pos = findNodePos(inorder, node.val);
        node.right = myBuildTree(inorder, postorder, pos + 1, indexRight);
        node.left = myBuildTree(inorder, postorder, indexLeft, pos);
        return node;
    }
    private int findNodePos(int[] inorder, int val) {
        for(int i = 0; i < inorder.length; i ++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}

public class TreeTest {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
    }
}
