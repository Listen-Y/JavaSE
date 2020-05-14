public class ReviewBinarySearchTree {
    static class Node {
        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    public  Node root = null;

    //查找
    public Node search(int key) {
        Node find = this.root;
        while (find != null) {
            if(key < find.key) {
                find = find.left;
            } else if (key > find.key) {
                find = find.right;
            } else {
                return find;
            }
        }
        return null;
    }

    //插入
    public void insert(int kay, int value) {
        if(this.root == null) {
            this.root = new Node(kay, value);
            return;
        }
        //先在树里找key这个结点，如果找到就覆盖value，如果没找到，parent就是待插入结点的父节点
        Node find = this.root;
        Node parent = null;
        while (find != null) {
            if (kay < find.key) {
                parent = find;
                find = find.left;
            } else if (kay > find.key) {
                parent = find;
                find = find.right;
            } else {
                //此时说明找到key了
                find.value = value;
                return;
            }
        }
        //此时parent结点就是待插入结点的父结点
        Node newNode = new Node(kay, value);
        if(kay < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    //删除
    public void delete(int key) {
        //先找到这个删除的结点和他的父结点
        Node find = this.root;
        Node parent = null;
        while (find != null) {
            if (key < find.key) {
                parent = find;
                find = find.left;
            } else if (key > find.key) {
                parent = find;
                find = find.right;
            } else {
                //此时就找到了
                remove(find, parent);
                return;
            }
        }
    }

    private void remove(Node find, Node parent) {
        //分为三大类讨论，第一find的左子树为空，第二find的右子树为空，第三find的左右子树都不为空
        //在第一和第二个里，在分别讨论find是根结点，find是parent的左子树，find是parent的右子树
        if (find.left == null) {
            if (find == this.root) {
                this.root = find.right;
            } else if (find == parent.left) {
                parent.left = find.right;
            } else {
                parent.right = find.right;
            }
        } else if (find.right == null) {
            if(find == this.root) {
                this.root = find.left;
            } else if (find == parent.left) {
                parent.left = find.left;
            } else {
                parent.right = find.left;
            }
        } else {
            //此时说明其左右子树都为空
            //在待删除结点的右子树找最小值，然后赋值给待删除结点，最后将最小值结点删除
            Node goat = find.right;
            Node goatParent = find;
            while (goat.left != null) {
                goatParent = goat;
                goat = goat.left;
            }
            //此时goat就是最小值那个结点选赋值，然后删除goat结点
            find.key = goat.key;
            find.value = goat.value;
            //删除有俩种可能，一种是goatparent的左子树，还有一种是右子树
            if(goat == goatParent.left) {
                goatParent.left = goat.right;
            } else {
                goatParent.right = goat.right;
            }
        }
    }

}
