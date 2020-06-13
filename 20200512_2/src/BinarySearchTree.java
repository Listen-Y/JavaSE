
public class BinarySearchTree {

    public Node root = null;

    public static class Node {
        public int value;
        public int key;
        public Node left;
        public Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //查找
    public Node search(int key) {
        Node find = this.root;
        while (find != null) {
            if(key < find.key) {
                find = find.left;
            } else if(key > find.key) {
                find = find.right;
            } else {
                //找到了
                return find;
            }
        }
        return null;
    }

    //增加
    public boolean insert(int key, int value) {
        if(this.root == null) {
            //如果此时为空树
            this.root = new Node(key, value);
            return true;
        }
        Node find = root;
        Node prev = null;
        while (find != null) {
           if(key < find.key) {
               prev = find;
               find = find.left;
           } else if (key > find.key) {
               prev = find;
               find = find.right;
           } else {
               //key相等，我们使value覆盖
               find.value = value;
               return true;
           }
        }
        //结束循环，说明此时找到要插入该结点的父节点
        Node newNode = new Node(key, value);
        if(key < prev.key) {
            prev.left = newNode;
        }else {
            prev.right = newNode;
        }
        return true;
    }

    //删除
    public void delete (int key) {
        if(this.root == null) {
            return;
        }
        Node find = this.root;
        Node parent = null;
        while (find != null) {
            if(key < find.key) {
                parent = find;
                find = find.left;
            } else if (key > find.key) {
                parent = find;
                find = find.right;
            } else {
                //找到了要删除的结点
                //分为三大类，find左子树为空，右子树为空，都不为空
                if(find.left == null) {
                    //待删除结点的左子树为空，分三种结果1。是根结点 2。是parent的左结点 3.是parent的右节点
                    if(find == this.root) {
                        this.root = find.right;
                        return;
                    } else if (find == parent.left) {
                        parent.left = find.right;
                        return;
                    } else {
                        parent.right = find.right;
                        return;
                    }
                } else if (find.right == null) {
                    //带删结点的右子树为空，分三种结果1。是根结点 2。是parent的左结点 3.是parent的右节点
                    if (find == this.root) {
                        this.root = find.left;
                        return;
                    } else if (find == parent.left) {
                        parent.left = find.left;
                        return;
                    } else {
                        parent.right = find.left;
                        return;
                    }
                } else {
                    //待删除结点左右都不为空，我们找到其左子树的最小结点，与待删除结点就行赋值，然后删除最小结点
                    Node goatParent = find;
                    Node goat = find.right;
                    while (goat.left != null) {
                        goatParent = goat;
                        goat = goat.left;
                    }
                    //就行赋值
                    find.key = goat.key;
                    find.value = goat.value;
                    //删除这个最小值的结点,分俩种情况，1.goat是goatparent的左结点2.goat是goatparent的右节点
                    if(goat == goatParent.left) {
                        //那么goat的左子树一定为空
                        goatParent.left = goat.right;
                        return;
                    } else {
                        //如果goat是goatparent的右节点，那么goatparent一定还指向find结点，而且此时goat的左结点还是为空
                        goatParent.right = goat.right;
                        return;
                    }

                }
            }
        }
    }
}
