package com;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-30
 * Time: 15:50
 */
public class Oj {

    private boolean key = false;

    /**
     * 一道经典的回溯想法的题,
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        char[][] chars = new char[rows][cols];
        int index = 0;
        for (int i = 0;  i< rows; i++) {
            for (int j = 0; j < cols; j++) {
                chars[i][j] = matrix[index++];
            }
        }
        for (int i = 0;  i< rows; i++) {
            for (int j = 0; j < cols; j++) {
                char[] temp =  new char[str.length];
                temp[0] = chars[i][j];
                char[][] charsCopy = new char[rows][cols];
                for (int k = 0; k < rows; k++) {
                    charsCopy[k] = Arrays.copyOf(chars[k], chars[k].length);
                }
                dfs(charsCopy, temp, 0, str, i, j);
                if (key) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] next = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private void dfs(char[][] chars, char[] temp, int index, char[] str, int x, int y) {
        if (chars[x][y] == '0') {
            return ;
        }
        if (temp[index] != str[index]) {
            return ;
        }
        if (index == str.length - 1) {
            key = true;
            return ;
        }
        chars[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int newX = x + next[i][0];
            int newY = y + next[i][1];
            if (newX < 0 || newX >= chars.length || newY < 0 || newY >= chars[0].length) {
                continue;
            }
            temp[index + 1] = chars[newX][newY];

            dfs(chars, temp, index + 1, str, newX, newY);
            if (key) {
                return;
            }
            temp[index + 1] = ' ';
        }
    }

    public static void main(String[] args) {
        Oj oj = new Oj();
        //"ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SGGFIECVAASABCEHJIGQEM"

        String s = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        String s1 = "SGGFIECVAASABCEHJIGQEM";
        System.out.println(oj.hasPath(s.toCharArray(), 5, 8, s1.toCharArray()));
    }
}
