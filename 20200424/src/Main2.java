/**
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 * （即逐层地，从左到右访问所有节点）
 */

import java.util.*;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        int index = 0;
        levelOrderINdex(root, index);
        return list;
    }

    public void levelOrderINdex(TreeNode root, int index) {
        if(root == null) {
            return;
        }
        if(list.size() <= index) {
            list.add(new ArrayList<>());
        }
        List<Integer> list2 = list.get(index);
        list2.add(root.val);
        levelOrderINdex(root.left, index + 1);
        levelOrderINdex(root.right, index + 1);
    }
}
public class Main2 {
}
