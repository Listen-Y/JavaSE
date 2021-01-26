import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-19
 * Time: 21:18
 */
public class Solution {

    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        fun(chars, 0, list);
        Collections.sort(list);
        String[] ans = new String[list.size()];
        for (int i= 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void fun(char[] chars, int index, List<String> list) {
        if (index == chars.length) {
            list.add(String.valueOf(chars));
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(chars, i, index);
            fun(chars, index + 1, list);
            swap(chars, i, index);
        }
    }

    private void swap(char[] arr, int index, int i) {
        char temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr
             ) {
            queue.offer(num);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    /** initialize your data structure here. */
    private PriorityQueue<Integer> big = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> small = new PriorityQueue<>();
    private int size = 0;

    public void addNum(int num) {
        if (size % 2 == 0) {
            small.offer(num);
            big.offer(small.poll());
        } else {
            big.offer(num);
            small.offer(big.poll());
        }
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (small.peek() + big.peek()) * 1.0 / 2;
        } else {
            return big.peek();
        }
    }

    public String minNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String num1 = "" + nums[i] + nums[j];
                String num2 = "" + nums[j] + nums[i];
                if (num1.compareTo(num2) > 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int num: nums) {
            ans.append(num);
        }
        return ans.toString();
    }



}
