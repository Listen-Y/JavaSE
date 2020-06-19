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

    public Node head;

    //查找
    public Node get(int key) {
        if (this.head == null) {
            return null;
        }
        Node cur = this.head;
        while (cur != null) {
            if (key < cur.key) {
                cur = cur.left;
            } else if(key > cur.key) {
                cur = cur.right;
            } else  {
                return cur;
            }
        }
        return null;
    }
    //增加
    public void put (int key, int value) {
        if(this.head == null) {
            this.head = new Node(key, value);
            return;
        }
        Node cur = this.head;
        Node parent = null;
        while (cur != null) {
            if(key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                cur.value = value;
                return;
            }
        }
        Node tmp = new Node(key, value);
        if(key < parent.key) {
            parent.left = tmp;
        } else {
            parent.right = tmp;
        }
    }
    //删除
    public void remove(int key) {
        if(this.head == null) {
            return;
        }
        Node cur = this.head;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                removeNode(cur, parent);
                return;
            }
        }
    }

    private void removeNode(Node cur, Node parent) {
        if (cur.left == null) {
            if (cur == this.head) {
                this.head = this.head.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if(cur.right == null) {
            if(cur == this.head) {
                this.head = this.head.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node goat = cur.right;
            Node goatParent = goat;
            while (goat.left != null) {
                goatParent = goat;
                goat = goat.left;
            }
            cur.key = goat.key;
            cur.value = goat.value;
            if(goat == goatParent.left) {
                goatParent.left = goat.right;
            } else {
                goatParent.right = goat.right;
            }
        }
    }
}
