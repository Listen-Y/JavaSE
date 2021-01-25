import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-19
 * Time: 12:59
 */
public class Solution {

      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int[] exchange(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return fun(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean fun(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return fun(A.left, B.left) && fun(A.right, B.right);
        } else {
            return false;
        }
    }
}


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            builder.append("#,");
            return builder.toString();
        }
        builder.append(root.val).append(",");
        builder.append(Serialize(root.left));
        builder.append(Serialize(root.right));
        return builder.toString();
    }

    private int index = 0;
    TreeNode Deserialize(String str) {
        String[] parts = str.split(",");
        return fun(parts);
    }

    private TreeNode fun(String[] parts) {
        if (index >= parts.length) {
            return null;
        }
        if (parts[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(parts[index++]));
        node.left = fun(parts);
        node.right = fun(parts);
        return node;
    }
}

public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            return builder.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                builder.append(cur.val);
                builder.append(',');
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                builder.append("#,");
            }
        }
        String str = builder.toString();
        return str.substring(0, str.length() - 1);
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] parts = str.split(",");
        return fun(parts);
    }

    private TreeNode fun(String[] parts) {
        TreeNode[] nodes = new TreeNode[parts.length];
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].equals("#")) {
                nodes[i] = new TreeNode(Integer.parseInt(parts[i]));
            }
        }
        for (int i = 0, j = 1; j < parts.length; i++) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[j++];
                nodes[i].right = nodes[j++];
            }
        }
        return nodes[0];
    }

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
        if (index > chars.length) {
            return;
        }
        if (index == chars.length) {
            list.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            if (i != index && chars[i] == chars[index]) continue;
            char temp = chars[i];
            chars[i] = chars[index];
            chars[index] = temp;
            fun(chars, index + 1, list);
            temp = chars[i];
            chars[i] = chars[index];
            chars[index] = temp;
        }
    }
}


