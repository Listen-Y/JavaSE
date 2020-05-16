import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
class Solution {
    private TreeNode cur = null;
    private boolean key = true;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = findLowestCommonAncestor(root, p, q);
        return cur;
    }

    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        TreeNode node = new TreeNode(0);
        if(root.val == p.val || root.val == q.val) {
            node.val = 1;
        }
        int i = 0;
        int j = 0;
        TreeNode nodeLeft = findLowestCommonAncestor(root.left, p, q);
        if(nodeLeft != null) {
            i = nodeLeft.val;
        }
        TreeNode nodeRight = findLowestCommonAncestor(root.right, p, q);
        if(nodeRight != null) {
            j = nodeRight.val;
        }
        if( key && node.val + i + j >= 2) {
            cur = root;
            key = false;
        }
        node.val += i + j;
        return node;
    }

    public TreeNode build() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node3.left=node5;
        node3.right=node1;
        node5.left=node6;
        node5.right=node4;
        node1.left=node0;
        node1.right=node7;
        return node3;
    }
}

//二叉树搜索树转换成排序双向链表。
class Solution1 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        TreeNode nodeLeft = Convert(pRootOfTree.left);
        if(nodeLeft == null) {
            nodeLeft = pRootOfTree;
        }else {
            TreeNode find = nodeLeft;
            while(find.right != null) {
                find = find.right;
            }
            find.right = pRootOfTree;
            pRootOfTree.left = find;
        }
        TreeNode nodeRight = Convert(pRootOfTree.right);
        if(nodeRight != null) {
            pRootOfTree.right = nodeRight;
            nodeRight.left = pRootOfTree;
        }
        return nodeLeft;
    }
}
//给定一个二叉树，确定它是否是一个完全二叉树。
class Solution2 {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFiretStep = true;
        while(isFiretStep) {
            TreeNode keyNode = queue.poll();
            if(keyNode.left != null && keyNode.right != null) {
                queue.offer(keyNode.left);
                queue.offer(keyNode.right);
            }else if(keyNode.left == null && keyNode.right != null) {
                return false;
            }else if(keyNode.left != null && keyNode.right == null) {
                isFiretStep = false;
                queue.offer(keyNode.left);
            }else {
                isFiretStep = false;
            }
        }
        while(queue.size() != 0) {
            TreeNode keyNode = queue.poll();
            if(keyNode.left != null || keyNode.right != null) {
                return false;
            }
        }
        return true;
    }
}

//给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
class Solution3 {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode nodeLeft = increasingBST(root.left);
        if(nodeLeft == null) {
            nodeLeft = root;
        }else {
            TreeNode find = nodeLeft;
            while(find.right != null) {
                find = find.right;
            }
            find.right = root;
            root.left = null;
        }
        TreeNode nodeRight = increasingBST(root.right);
        if(nodeRight != null) {
            root.right = nodeRight;
            nodeRight.left = null;
        }
        return nodeLeft;
    }
}

public class TreeTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.build();
        System.out.println(solution.lowestCommonAncestor(root, new TreeNode(6), new TreeNode(4)).val);
        Queue<Integer> queue = new LinkedList<>();
    }
}
