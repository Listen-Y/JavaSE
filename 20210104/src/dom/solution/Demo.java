package dom.solution;

import javax.rmi.CORBA.Util;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-04
 * Time: 15:12
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        //System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        //System.out.println(solution.waysToSplit(new int[]{1, 1, 1}));

//        solution.string.split("");
//        System.out.println(Math.sqrt(3));
//        System.out.println(solution.mySqrt(4));

        int count = 0;
        while (count++ < 10) {
            System.out.println(System.currentTimeMillis() % 254);
            Thread.sleep(10);
        }

    }
}
