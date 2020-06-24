import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<List<Integer>> lists;

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        lists = new ArrayList<>();
        largestValuesHealper(root, 0);
        for (List<Integer> list : lists) {
            int max = list.get(0);
            for (int x : list) {
                if (x > max) {
                    max = x;
                }
            }
            ret.add(max);
        }
        return ret;
    }

    private void largestValuesHealper(TreeNode root, int count) {
        if (root == null) {
            return;
        }
        if (lists.size() <= count) {
            lists.add(new ArrayList<>());
        }
        List<Integer> list = lists.get(count);
        list.add(root.val);
        largestValuesHealper(root.left, count + 1);
        largestValuesHealper(root.right, count + 1);
    }
}

public class OJTest {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        System.out.println(lists.size() <= 0);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.sort((o1, o2) -> o1 - o2);
    }
}
