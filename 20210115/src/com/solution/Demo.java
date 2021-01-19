package com.solution;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-16
 * Time: 12:23
 */
public class Demo {
    public static void main(String[] args) {
/*        char[][] boards = new char[][] {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        Solution solution = new Solution();
        boolean exist = solution.exist(boards, word);
        System.out.println(exist);*/

        Solution solution = new Solution();
        System.out.println(solution.movingCount(16, 8, 4));
    }
}
