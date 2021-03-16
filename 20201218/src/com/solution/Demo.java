package com.solution;

import com.set.MySet;
import com.set.MySet2;
import com.set.MySetIterator;

import java.util.*;
import java.util.jar.JarOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-18
 * Time: 10:25
 */
public class Demo {

    public static <MySetIterator> void main(String[] args) {
/*        Solution solution = new Solution();
        int[] array = new int[] {1,-2,3,10,-4,7,2,-5};
        System.out.println(solution.FindGreatestSumOfSubArray(array));*/

        Map<Solution, Solution> map = new HashMap<>();
        Set<String> stringSet = new HashSet<>();


        MySet2<String> mySet = new MySet2<>(10);
        mySet.add("aaa");
        mySet.add("bbb");
        mySet.add("aaa");
        mySet.add("ccc");
        mySet.add("aa");
        mySet.add("ccc");
        mySet.add("ccc");
        com.set.MySetIterator<String> stringMySetIterator = mySet.get();
        while (stringMySetIterator.hasNext()){
            System.out.println(stringMySetIterator.next());
        }
    }
}
