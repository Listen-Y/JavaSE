import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-k-closest-elements
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {

    static class Element {
        public int key;
        public int value;
        public Element(int key, int x) {
            this.key = key;
            this.value = Math.max(x - key, key - x);
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Element> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new Element(i, x));
        }
        list.sort(new Comparator<Element>() {
            public int compare(Element o1, Element o2) {
                int ret1 = o1.value;
                int ret2 = o2.value;
                if(ret1 == ret2) {
                    return o1.key - o2.key;
                }
                return ret1 - ret2;
            }
        });
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list1.add(list.get(i).key);
        }
        list1.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return list1;
    }
}


//根据一棵树的前序遍历与中序遍历构造二叉树。
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

class Solution1 {
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHealper(preorder, inorder, 0, preorder.length);
    }
    private TreeNode buildTreeHealper(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int pos = findPos(inorder, preorder[index]);
        index++;
        root.left = buildTreeHealper(preorder, inorder, left, pos);
        root.right = buildTreeHealper(preorder, inorder, pos + 1, right);
        return root;
    }
    private int findPos(int[] inorder, int key) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}

//根据一棵树的中序遍历与后序遍历构造二叉树
class Solution2 {
    private int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return buildTreeHealper(inorder, postorder, 0, postorder.length);
    }
    private TreeNode buildTreeHealper(int[] inorder, int[] postorder, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (index < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int pos = findPos(inorder, postorder[index]);
        index--;
        root.right = buildTreeHealper(inorder, postorder, pos + 1, right);
        root.left = buildTreeHealper(inorder, postorder, left, pos);
        return root;
    }
    private int findPos(int[] inorder, int key) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}