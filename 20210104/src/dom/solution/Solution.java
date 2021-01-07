package dom.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-04
 * Time: 15:08
 */
public class Solution {

    protected String string = "";

    /**
     * 获得最长连续字符串长度
     * 使用一个map记录已获得的字符
     * 使用双指针表示不连续的字符串, 如果fast的不包括就加进去, 包括了就删除slow下标的字符, 但是由于我下标的slow是先加的
     * 所以要删除slow-1下标的字符, 然后在进行有无重复判断
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null ||s.length() == 0) {
            return 0;
        }
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int ret = 0;
        while (fast < len) {
            if (slow != 0) {
                set.remove(s.charAt(slow - 1));
            }
            while (fast < len && !set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast));
                fast++;
            }
            ret = Math.max(ret, fast - slow);
            slow++;
        }
        return ret;
    }

    /**
     * 贪心算法
     * 先对二维数组进行排序
     * 优先选择容量最大箱子, 箱子的数量合理区最大 Math.min(truckSize, boxTypes[i][0]);
     * 记录了箱子的数量, 就需要箱子的数量就下降, sum累加
     * https://leetcode-cn.com/problems/maximum-units-on-a-truck/submissions/
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (truckSize <= 0) {
            return 0;
        }
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int sum = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int num = Math.min(truckSize, boxTypes[i][0]);
            truckSize -= num;
            sum += boxTypes[i][1] * num;
        }
        return sum;
    }

    /**
     * 俩数之和
     * 使用一个map记录遍历过的数据和下标, 后续target - nums[i]
     * 如果map见过这个数据, 就返回俩下标, 否则继续遍历
     * https://leetcode-cn.com/problems/two-sum/submissions/
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.get(need) != null) {
                return new int[] {map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 算是一道大数据俩数相加
     * 每个数据的2次幂由题知最大为2的22次方
     * 所以target就是2^0~2~22
     * 每次对一个num都进行need计算, 如果此前出现过need就说明有一个合理的组合, 并且还是有map对数据进行统计
     * 如果出现多次need, 直接ans+=统计的数据即可
     * https://leetcode-cn.com/problems/count-good-meals/
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        if (deliciousness == null) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : deliciousness) {
            for (int i = 0; i < 22; i++) {
                int target = (int) Math.pow(2, i);
                int need = target - num;
                if (need < 0) continue;
                if (map.get(need) != null) {
                    ans += map.get(need);
                    ans %= 1000000007;
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans % 1000000007;
    }

    public int waysToSplit(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long ans = 0;
        for (int one = 1; one < len - 1; one++) {
            int two = one + 1;
            while (true) {
                while (two < len && (sum[two] - sum[one] < sum[one])) {
                    two++;
                }
                if (two == len) {
                    break;
                }
                if ((sum[len] - sum[two]) >= (sum[two] - sum[one])) {
                    ans++;
                }
                two++;
            }
        }
        return (int)(ans % 1000000007);
    }

    public int mySqrt(int num) {
        if (num <= 0) {
            return 0;
        }
        int left = 0;
        int right = num * 2 + 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int key = mid * mid;
            if (key < num) {
                left = mid + 1;
            } else if (key > num) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }


}
