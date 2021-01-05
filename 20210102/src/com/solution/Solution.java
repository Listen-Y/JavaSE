package com.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-02
 * Time: 17:46
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {

    /**
     * 序列化与反序列化二叉树, 使用递归的方式完成
     * 首先看其根节点是否为null, 否则sb.append val + ,
     * 然后在append其左节点和右节点, 为空append #,
     * 最后返回sb.string
     *
     * 反序列化就是先分割
     * 记录此时index为0
     * 不是#就初始化节点, 然后index++看其左节点, index++看其右节点
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            builder.append("#,");
            return builder.toString();
        }
        builder.append(root.val + ",");
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

    /**
     * 二叉搜索树找公共祖先
     * 分别找到俩个节点的访问路径, 然后保存下来
     * 遍历, 每次相等直接记录
     * 如果不相等了就break
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode ret = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                ret = pPath.get(i);
            } else {
                break;
            }
        }
        return ret;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> ret = new ArrayList<>();
        if (root == null || target == null) {
            return ret;
        }
        TreeNode cur = root;
        while (cur != null) {
            ret.add(cur);
            if (target.val > cur.val) {
                cur = cur.right;
            } else if (target.val < cur.val) {
                cur = cur.left;
            } else {
                break;
            }
        }
        return ret;
    }

    /**
     * 这种做法完全使用了二叉搜索树的性质
     * 如果俩个都小于root.val
     * 往左走
     * 都大于往又走, 否则, 直接返回root
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * 进阶版找公共祖先
     * 用递归的方式, 如果此时root为null. 或者root为某一个的节点就直接返回root
     * 否则采用后序遍历的方式, 一开始往左走, 找其左边看有没有
     * 直到最后看left和right哪个为null
     * 返回另一个, 否则返回root
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p ||root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


}
