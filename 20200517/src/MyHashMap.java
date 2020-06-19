public class MyHashMap {

    static class Node {
        public int key;
        public int value;
        public Node next;

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

    private Node[] array;
    private int count;

    public MyHashMap() {
        this.array = new Node[4];
        this.count = 0;
    }

    //查找
    public Node get(int key) {
        int index = hashFunc(key);
        Node cur = this.array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    private int hashFunc(int key) {
        return key % this.array.length;
    }
    //增加
    public void add(int key, int value) {
        int index = hashFunc(key);
        Node cur = this.array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        cur = this.array[index];
        Node newHead = new Node(key,value);
        newHead.next = cur;
        this.array[index] = newHead;
        count++;
    }
    //删除
    public void remove(int key) {
        int index = hashFunc(key);
        if (this.array[index] == null) {
            return;
        }
        if (this.array[index].key == key) {
            this.array[index] = this.array[index].next;
            count--;
            return;
        }
        Node cur = this.array[index].next;
        Node parent = this.array[index];
        while (cur != null) {
            if(cur.key == key) {
                parent.next = cur.next;
                count--;
                return;
            }
            parent = cur;
            cur = cur.next;
        }
    }
}
