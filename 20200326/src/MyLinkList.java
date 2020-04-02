public class MyLinkList {
    private Node head;
    public MyLinkList() {
        this.head = null;
    }
    //头插法
  public void addFirst(int data) {
        Node elem = new Node(data);
        if(this.head == null) {
            this.head = elem;
            return;
        }
        elem.next = this.head;
        this.head = elem;
    }
  //尾插法
  public void addLast(int data) {
      Node elem = new Node(data);
      if(this.head == null) {
          this.head = elem;
          return;
      }
      Node find = this.head;
      while (find.next != null) {
          find =find.next;
      }
      elem.next = find.next;
      find.next = elem;
    }
  //任意位置插入,第一个数据节点为0号下标
  public boolean addIndex(int index,int data) {
        Node elem = new Node(data);
        if(index < 0 || index > size()) {
            System.out.println("位置不合法");
            return false;
        }
        if(index == 0) {
            addFirst(data);
            return true;
        }
        if(index == size()) {
            addLast(data);
            return true;
        }
        Node find = findIndex(index);
        elem.next = find.next;
        find.next = elem;
        return true;
    }

    private Node findIndex(int index) {
        Node find = this.head;
        int count = 0;
        while (count < index - 1) {
            find = find.next;
            count ++;
        }
        return find;
    }
  //查找是否包含关键字key是否在单链表当中
  public boolean contains(int key) {
        Node find = this.head;
        while (find != null) {
            if(find.date == key) {
                return true;
            }
            find = find.next;
        }
        return false;
    }
 //删除第一次出现关键字为key的节点
 public void remove(int key) {
        Node find = this.head;
        if(this.head == null) {
            return;
        }
        if(this.head.date == key) {
            this.head = this.head.next;
            return;
        }
        while (find.next != null) {
            if(find.next.date == key) {
                find.next = find.next.next;
                return;
            }else {
                find = find.next;
            }
        }
     System.out.println("无此节点");
    }
 //删除所有值为key的节点
 public void removeAllKey(int key) {
        Node find = this.head;
        if(this.head == null) {
            return;
        }
        Node cur = this.head;
        find = find.next;
        while(find != null) {
            if(find.date == key) {
                cur.next = find.next;
                find = find.next;
            }else {
                cur = find;
                find = find.next;
            }
        }
        if(this.head.date == key) {
            this.head = this.head.next;
        }
    }
 //得到单链表的长度
 public int size() {
        Node find = this.head;
        int count = 0;
        while (find != null) {
            count ++;
            find = find.next;
        }
        return count;
    }
 public void display() {
        Node find = this.head;
        while (find != null) {
            System.out.print(find.date + " ");
            find = find.next;
        }
     System.out.println();
    }
  public void clear() {
        this.head = null;
    }

}
