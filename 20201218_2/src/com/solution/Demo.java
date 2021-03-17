package com.solution;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-18
 * Time: 20:40
 */
public class Demo {

    public static void main(String[] args) {
        int num = 21;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
            if (num == 0) {
                break;
            }
        }
        System.out.println(count);
    }
}
