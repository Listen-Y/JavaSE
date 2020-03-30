import javax.naming.InsufficientResourcesException;

class Node {
    public int date;
    public Node next;

    public Node (int date) {
        this.date = date;
        this.next = null;
    }

    public Node() {

    }
}


class MyList {
    private Node head;

    public MyList() {
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
            addFirst(data);
            return;
        }
        Node find = this.head;
        while(find.next != null) {
            find = find.next;
        }
        find.next = elem;
     }
     //任意位置插入,第一个数据节点为0号下标
     public void addIndex(int index,int data) {
        int size = size();
        if(index < 0 || index > size) {
            System.out.println("位置错误");
            return;
        }
        if(index == 0) {
            addFirst(data);
        }else if(index == size) {
            addLast(data);
        }else {
            Node elem = new Node(data);
            Node find = findIndex(index);
            elem.next = find.next;
            find.next = elem;
        }
     }

     public Node findIndex(int index) {
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
        while(find != null) {
            if(find.date == key) {
                return true;
            }else {
                find = find.next;
            }
        }
        return false;
     }
     //删除第一次出现关键字为key的节点
     public void remove(int key) {
        Node find = this.head;
         if(find.date == key) {
             find = find.next;
             this.head = find;
             return;
         }
        while (find != null) {
            if(find.next.date == key) {
                find.next = find.next.next;
                return;
            }
            find = find.next;
        }
         System.out.println("没有" + key);

     }
     //删除所有值为key的节点
     public void removeAllKey(int key) {
        Node find = this.head;
         Node cur = this.head;
        if(find == null) {
            System.out.println("链表为空");
            return;
        }
         while (find.next != null) {
             if(find.next.date == key) {
                 find = find.next;
                 cur.next = find.next;
             }else {
                 find = find.next;
                 cur = find;
             }
         }
         if(this.head.date == key) {
             this.head = this.head.next;
         }
     }
     //得到单链表的长度
     public int size() {
        if(this.head == null) {
            return 0;
        }
        Node find = this.head;
        int count = 1;
        while(find .next !=null) {
            find = find.next;
            count ++;
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


public class List {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.addFirst(10);
        list.display();
        list.addFirst(20);
        list.display();
        list.addLast(30);
        list.display();
        System.out.println(list.size());
        list.addIndex(2, 40);
        list.display();
        if (list.contains(30)) {
            System.out.println("OK");
        }
        list.remove(30);
        list.display();
        list.remove(20);
        list.display();
        list.addIndex(1,20);
        list.addIndex(2, 30);
        list.display();
        list.remove(30);
        list.display();
        System.out.println("=====1======");
        MyList list1 = new MyList();
        int[] arr = new int[] {2,2,2,2,0,2,0,2,2,2,0,0,2,2};
        for (int i = 0; i < arr.length; i++) {
            list1.addIndex(i,arr[i]);
        }
        list1.removeAllKey(2);
        list1.display();
        System.out.println("=======2=======");
        MyList list2 = new MyList();
        for (int i = 0; i < 4; i++) {
            list2.addIndex(i,arr[i]);
        }
        list2.removeAllKey(2);
        list2.display();
        MyList list3 = new MyList();
        System.out.println("========3=======");
        int[] arr2 = new int[] {2,3,2,2,3,3,4,3,2,2,3,2,2,3,4,3,2,2,1,2,2,3,2,2,2,2};
        for (int i = 0; i < arr2.length; i++) {
            list3.addIndex(i, arr2[i]);
        }
        list3.removeAllKey(2);
        list3.display();


    }
}
