//判断俩颗树是否相等
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if( p.val != q.val) {
            return false;
        }
        boolean result = isSameTree(p.left, q.left);
        if(!result) {
            return false;
        }
        result = isSameTree(p.right, q.right);
        return result;
    }
}
public class Test {
    public static void main(String[] args) {

    }
}
