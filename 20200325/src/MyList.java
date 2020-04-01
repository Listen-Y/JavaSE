class Noed {
    public int date;
    public Noed next;
    public Noed(int date) {
        this.date = date;
    }
    public Noed() {
    }
}

class MyLinkList {
    private Noed head;
    public MyLinkList() {
        this.head = null;
    }
    //头插法
  public void addFirst(int data) {
        Noed elem = new Noed(data);
        if(this.head == null) {
            this.head = elem;
            return;
        }
        elem.next = this.head;
        this.head = elem;
  }
  //尾插法
  public void addLast(int data) {
        Noed elem = new Noed(data);
        if(this.head == null) {
            this.head = elem;
            return;
        }
        Noed find = this.head;
        while (find.next !=null) {
            find = find.next;
        }
        find.next = elem;
  }
  //任意位置插入,第一个数据节点为0号下标
  public boolean addIndex(int index,int data) {
        Noed elem = new Noed(data);
        if(index < 0 || index > size()) {
            System.out.println("位置错误");
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
        Noed find = findINdex(index);
        elem.next = find.next;
        find.next = elem;
        return true;
    }

    public Noed findINdex(int index) {
        Noed find = this.head;
        int count = 0;
        while (count < index - 1) {
            find = find.next;
            count ++;
        }
        return find;
    }
  //查找是否包含关键字key是否在单链表当中
  public boolean contains(int key) {
        Noed find = this.head;
        if(find == null) {
            return false;
        }
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
        Noed find = this.head;
        if(this.head == null) {
            System.out.println("链表为空");
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
            }
            find = find.next;
        }
              System.out.println("无此节点");
    }
 //删除所有值为key的节点
          public void removeAllKey(int key) {
        Noed find = this.head;
        Noed cur = this.head;
        if(this.head == null) {
            System.out.println("链表为空");
            return;
        }
        find = find.next;
            while (find != null) {
                if(find.date == key) {
                    cur.next = find.next;
                    find = find.next;
                }else  {
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
        Noed find = this.head;
        int count = 0;
        while (find != null) {
            count ++;
            find = find.next;
        }
     return count;
    }

  public void display() {
     Noed find = this.head;
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
public class MyList {
    public static void main(String[] args) {
        MyLinkList link = new MyLinkList();
        link.addFirst(20);
        link.addFirst(10);
        link.addLast(40);
        link.addIndex(2,30);
        link.display();
        System.out.println(link.size());
        if (link.contains(10)) {
            System.out.println("OK");
        }
        if (link.contains(40)) {
            System.out.println("OK");
        }
        link.remove(10);
        link.remove(40);
        link.display();
        link.clear();
        link.display();
        System.out.println("=======================");
        MyLinkList link2 = new MyLinkList();
        int[] arr = new int[] {2,2,2,3,3,2,2,3,3,2,3,2,3,2,2,2,3,3,2,2,2,3,3,3,2,2,2,2,3,2,2};
        for (int i = 0; i < arr.length; i++) {
            link2.addIndex(i, arr[i]);
        }
        link2.display();
        link2.remove(2);
        link2.display();
        link2.removeAllKey(2);
        link2.display();
        MyLinkList link3 = new MyLinkList();
        link3.addFirst(2);
        link3.addFirst(1);
        link3.addFirst(1);
        link3.addFirst(1);
        link3.display();
        link3.remove(3);
        link3.display();
    }
}
