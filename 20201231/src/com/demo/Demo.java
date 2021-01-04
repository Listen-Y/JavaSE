package com.demo;


import com.solution.Solution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-31
 * Time: 17:38
 */

enum Beat {
    P1,
    P2,
    P3,
    P4,
}

enum Heart {
    PA,
    PB,
    PC,
    PD,

}
public class Demo {

    public static void main1(String[] args) {

        Heart heart = Heart.valueOf("PA");
        Heart heart1 = Heart.PB;
        System.out.println(heart.name());
        System.out.println(heart.compareTo(heart1));
        System.out.println(heart.ordinal());
        System.out.println(heart1.ordinal());
        System.out.println(heart.equals(heart1));
        System.out.println(heart);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(8);
        //{8,6,10,5,7,9,11}
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        ArrayList<ArrayList<Integer>> print = solution.Print2(root);
        for (ArrayList<Integer> l : print
                ) {
            System.out.println(l);
        }
    }
}



