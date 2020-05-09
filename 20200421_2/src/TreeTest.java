/**
 *
 * 二叉树题先考虑根结点 再用递归考虑其左子树 和右子树
  */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//判断一个树是否为镜像对称  主要思想就是将树的根节点的左子树和右子树判拆开，传入另外一个方法
// 这个方法判断这两个树的一个树的左结点是不是等于另外一个树的右节点
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return funtion(root.left, root.right);
    }

    public boolean funtion(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && funtion(root1.left, root2.right) && funtion(root1.right, root2.left);
    }
}
//判断是否为平衡二叉树  平衡二叉树就是结点的左深度和右深度差值要小于等于1
class Solution {
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int lengthLeft = maxDepth(root.left);
        int lengthRight = maxDepth(root.right);
        if(lengthLeft > lengthRight) {
            return ((lengthLeft - lengthRight) <= 1) && isBalanced(root.left) && isBalanced(root.right);
        }
        return ((lengthRight - lengthLeft) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
}

public class TreeTest {
    //判断是否为一个树的子树
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s== null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null) {
                return true;
            }
            return funtion(root.left, root.right);
        }

        public boolean funtion(TreeNode root1, TreeNode root2) {
            if(root1 == null && root2 == null) {
                return true;
            }
            if(root1 == null || root2 == null) {
                return false;
            }
            return root1.val == root2.val && funtion(root1.left, root2.right) && funtion(root1.right, root2.left);
        }
    }

    //求树的深度
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //if(root.left == null && root.right == null) {
        // return 1;
        //}
        //int lengthLeft = maxDepth(root.left);
        //int lengthRight = maxDepth(root.right);
        //return  1 + (lengthLeft > lengthRight ? lengthLeft : lengthRight);
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println(Math.max(3,32) + 1);
    }
}
