import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-02-03
 * Time: 20:30
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 连续子数组的最大和
     * @param array
     * @return
     */
    public int fun(int[] array) {
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + Math.max(array[i - 1], 0);
            ret = Math.max(ret, array[i]);
        }
        return ret;
    }

    /**
     * 从左上到右下的最大路径和
     * @param a
     * @return
     */
    public int maxPath(int[][] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int row = a.length;
        int col = a[0].length;
        for (int i = 1; i < col; i++) {
            a[0][i] += a[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            a[i][0] += a[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                a[i][j] += Math.max(a[i - 1][j], a[i][j - 1]);
            }
        }
        return a[row - 1][col - 1];
    }

    /**
     * 数组的左旋和右旋
     * @param num
     * @param k
     */
    public void fun(int[] num, int k) {
        if (num == null || k == 0) {
            return;
        }
        int len = num.length;
        k %= len;
        int key = len - k;
        int[] cur = new int[len];
        int index = 0;
        for (int i = key; i < len; i++) {
            cur[index++] = num[i];
        }
        for (int i = 0; i < key; i++) {
            cur[index++] = num[i];
        }
        System.arraycopy(cur, 0, num, 0, len);
    }

    /**
     * 最早出现并且只出现三次的字符
     * @param eg
     * @return
     */
    public char fun(String eg) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0 ; i < eg.length(); i++) {
            char cur = eg.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (map.get(cur) == 3) {
                queue.offer(cur);
            }
        }
        char ret = '0';
        while (!queue.isEmpty()) {
            if (map.get(queue.peek()) == 3) {
                ret = queue.peek();
                break;
            }
            queue.poll();
        }
        return ret;
    }
}
