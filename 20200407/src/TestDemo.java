/**
 *
 * Random System Runtime
 */
import java.util.*;

import java.util.Arrays;

public class TestDemo {

    public static boolean haveSameNums(int[] nums ,int num) {
        for (int i : nums
             ) {
            if(i == num) {
                return true;
            }
        }
        return false;
    }

    public static void findRandomNums(int[] nums) {
        int count = 0;
        while (count <5) {
            int num = new Random().nextInt(22) + 1;
           if( ! haveSameNums(nums, num)) {
               nums[count] = num;
               count ++ ;
           }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[5];
        findRandomNums(nums);
        System.out.println(Arrays.toString(nums));
    }



    public static void main1(String[] args) {
        //System.out.println(System.currentTimeMillis());//当前时间减去1970 01 01 0 0 的时间差，移毫秒为单位
        int[] arr = new int[] {1,2,3,4,5};
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println(arrCopy.length);
        arrCopy[2] = 999;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrCopy));
        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("user.dir"));

    }
}
