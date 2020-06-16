

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
    //定义一个结点数组存放
    private Node[] array;
    //当前元素个数
    private int size;
    //用于判断是否需要扩容的负载因子
    private static final double LOAD_FACTOR = 0.75;

    public MyHashMap() {
        //定义数组长度为素数可以减少降低冲突
        this.array = new Node[3];
    }
    //增加
    public void put(int key, int value) {
        //首先获取根据哈希函数得到下标
        int index = hashFunc(key);
        //判断此时有没有这个key如果有就覆盖value
        Node head = this.array[index];
        if(head == null) {
            this.array[index] = new Node(key, value);
            this.size++;
            if(( (double)this.size / this.array.length ) >= LOAD_FACTOR) {
                //进行扩容
                resize();
            }
            return;
        }
        while (head != null) {
            if(head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        //此时说明数组里没有key，我们进行头插这个key的结点
        head = this.array[index];
        Node newHead = new Node(key, value);
        newHead.next = head;
        this.array[index] = newHead;
        this.size ++;
        if(( (double)this.size / this.array.length ) >= LOAD_FACTOR) {
            //进行扩容
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[this.array.length * 2];
        //遍历原有数据放到新的数组当中
        for (Node node : this.array) {
            Node next;
            for (Node cur = node; cur != null; cur = next) {
                next = cur.next;
                cur.next = null;
                //根据哈希函数得到下标，放到新的数组中
                int index = cur.key % newArray.length;
                if (newArray[index] != null) {
                    //头插
                    cur.next = newArray[index];
                }
                newArray[index] = cur;
            }
        }
        this.array = newArray;
    }

    private int hashFunc(int key) {
        return key % this.array.length;
    }
    //查找
    public Node get(int key) {
        //通过哈希函数得到下标
        int index = hashFunc(key);
        //遍历cur这个链表找key
        for (Node cur = this.array[index]; cur != null; cur = cur.next) {
            if(cur.key == key) {
                return cur;
            }
        }
        return null;
    }
    //删除
    public void remove(int key) {
        //通过哈希函数得到下标
        int index = hashFunc(key);
        //如果头结点为空
        if(this.array[index] == null) {
            return;
        }
        //如果头结点就是key
        if(this.array[index].key == key) {
            this.array[index] = this.array[index].next;
            this.size--;
            return;
        }
        //进行链表删除
        Node parent = this.array[index];
        Node find = parent.next;
        while (find != null) {
            if(find.key == key) {
                parent.next = find.next;
                this.size--;
                return;
            }
            parent = find;
            find = find.next;
        }
    }
}
