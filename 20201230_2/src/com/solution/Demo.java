package com.solution;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-30
 * Time: 15:03
 */
public class Demo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Solution solution = new Solution();
        solution.bigSort(root);
        System.out.println();
        solution.midSort(root);
        System.out.println();
        solution.lastSort(root);
        char[] chars = new char[3];
        System.out.println(Arrays.toString(chars));
    }
}
