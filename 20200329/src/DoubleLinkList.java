public class DoubleLinkList {
    private ListNode head;
    private ListNode last;
    public DoubleLinkList() {
        this.head = null;
        this.last = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode elem = new ListNode(data);
        if(this.head == null) {
            this.head = elem;
            this.last = elem;
            return;
        }
        this.head.prev = elem;
        elem.next = this.head;
        this.head = elem;
    }
    //尾插法
    public void addLast(int data){
        ListNode elem = new ListNode(data);
        if(this.head == null) {
            this.head = elem;
            this.last = elem;
        }
        elem.prev = this.last;
        this.last.next = elem;
        this.last = elem;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            throw new NullPointerException();
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        ListNode elem = new ListNode(data);
        ListNode find = findIndex(index);
        find.prev.next = elem;
        elem.prev = find.prev;
        elem.next = find;
        find.prev = elem;
    }

    private ListNode findIndex(int index) {
        ListNode find = this.head;
        int count = 0;
        while (count < index) {
            find = find.next;
            count ++;
        }
        return find;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        if(this.head == null) {
            return false;
        }
        ListNode find = this.head;
        while (find != null) {
            if(find.data == key) {
                return true;
            }
            find = find.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head.data == key) {
            this.head.next.prev = null;
            this.head = this.head.next;
            return;
        }
        ListNode find = this.head.next;
        while (find.next != null) {
            if(find.data == key) {
                find.prev.next = find.next;
                find.next.prev = find.prev;
                return;
            }
            find = find.next;
        }
        if(this.last.data == key) {
            this.last.prev.next = null;
            this.last = this.last.prev;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(this.head == null) {
            return;
        }
        ListNode find = this.head.next;
        while (find.next != null) {
            if(find.data == key) {
                find.prev.next = find.next;
                find.next.prev = find.prev;
            }
            find = find.next;
        }
        if(this.head.data == key) {
            this.head.next.prev = null;
            this.head = this.head.next;
        }
        if(this.last.data == key) {
            this.last.prev.next = null;
            this.last = this.last.prev;
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode find = this.head;
        int count = 0;
        while (find != null) {
            find = find.next;
            count ++;
        }
        return count;
    }
    public void display(){
        ListNode find = this.head;
        while (find != null) {
            System.out.print(find.data + " ");
            find = find.next;
        }
        System.out.println();
    }
    public void clear(){
        this.head = null;
        this.last = null;
    }
}
