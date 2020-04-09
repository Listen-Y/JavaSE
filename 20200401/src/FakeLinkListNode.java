public class FakeLinkListNode {
    private ListNode fakeHead;
    private ListNode last;

    public FakeLinkListNode(){
        this.fakeHead = new ListNode("0");
        this.last = null;
    }

    //头插法
  public void addFirst(String strDate) {
      ListNode elem = new ListNode(strDate);
        if(this.fakeHead.next == null) {
            this.fakeHead.next = elem;
            elem.prev = this.fakeHead;
            this.last = elem;
            return;
        }
        this.fakeHead.next.prev = elem;
        elem.next = this.fakeHead.next;
        this.fakeHead.next = elem;
        elem.prev = this.fakeHead;
  }
  //尾插法
  public void addLast(String strDate) {
      ListNode elem = new ListNode(strDate);
        if(this.fakeHead.next == null) {
            this.fakeHead.next = elem;
            elem.prev = this.fakeHead;
            this.last = elem;
            return;
        }
        elem.prev = this.last;
        this.last.next = elem;
        this.last = elem;
    }
 //任意位置插入,第一个数据节点为0号下标
 public void addIndex(int index,String strDate) {
        if(index < 0 || index > size()) {
            System.out.println("INDEX NULL ERRPE");
            return;
        }
        if(index == 0) {
            addFirst(strDate);
            return;
        }
        if(index == size()) {
            addLast(strDate);
            return;
        }
        ListNode find = findIndex(index);
        ListNode elem = new ListNode(strDate);
        elem.next = find.next;
        find.next.prev = elem;
        find.next = elem;
        elem.prev = find;
    }

    private ListNode findIndex(int inedx) {
        ListNode find = this.fakeHead.next;
        int count = 0;
        while (count < inedx - 1) {
            find = find.next;
            count ++;
        }
        return find;
    }
  //查找是否包含关键字key是否在单链表当中
  public boolean contains(String key) {
        ListNode find = this.fakeHead.next;
        while (find != null) {
            if(find.strDate.equals(key)) {
                return true;
            }
            find = find.next;
        }
        return false;
    }
  //删除第一次出现关键字为key的节点
  public void remove(String key) {
        ListNode find = this.fakeHead.next;
        while (find.next != null) {
            if(find.strDate.equals(key)) {
                find.prev.next = find.next;
                find.next.prev = find.prev;
                return;
            }
            find = find.next;
        }
        if(this.last.strDate.equals(key)) {
            this.last = this.last.prev;
            this.last.next = null;
            return;
        }
      System.out.println("NO KEY");
    }
  //删除所有值为key的节点
  public void removeAllKey(String key) {
        ListNode find = this.fakeHead.next;
        while (find.next != null) {
            if(find.strDate.equals(key)) {
                find.prev.next = find.next;
                find.next.prev = find.prev;
            }
            find = find.next;
        }
        if(this.last.strDate.equals(key)) {
            this.last = this.last.prev;
            this.last.next = null;
        }
    }
  //得到单链表的长度
  public int size() {
        ListNode find = this.fakeHead.next;
        int count = 0;
        while (find != null) {
            count ++;
            find = find.next;
        }
        return count;
    }
  public void display() {
        ListNode find = this.fakeHead.next;
        while (find != null) {
            System.out.print(find.strDate + " ");
            find = find.next;
        }
      System.out.println();
  }
  public void clear() {
        this.fakeHead.next = null;
        this.last = null;
  }
}
