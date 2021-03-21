package com.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-21
 * Time: 20:28
 */
public class Test {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = new int[] {9,8,7,6,5,4,3,2,1};
        sort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
