/**
 * 复习  双向LinkedList
 */
class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}

class MyDoubleLinkedList {
    private Node head;


    //头插法
  public void addFirst(int data) {
      if(this.head == null) {
          this.head = new Node(data);
          return;
      }
      Node node = new Node(data);
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
  }
 //尾插法
 public void addLast(int data) {
      if(this.head == null) {
          this.head = new Node(data);
          return;
      }
      Node find = this.head;
      while (find.next != null) {
          find = find.next;
      }
      Node node = new Node(data);
      find.next = node;
      node.prev = find;
  }
  //任意位置插入,第一个数据节点为0号下标
  public boolean addIndex(int index,int data) {
      int size = size();
      if(index < 0 || index > size) {
          return false;
      }
      if(index == 0) {
          addFirst(data);
          return true;
      }
      if(index == size) {
          addLast(data);
          return true;
      }
      Node find = findIndexNode(index);
      Node node = new Node(data);
      find.next.prev = node;
      node.next = find.next;
      find.next = node;
      node.prev = find;
      return true;
  }

    private Node findIndexNode(int index) {
      Node find = this.head;
        for (int i = 0; i < index - 1; i++) {
            find = find.next;
        }
        return find;
    }

    //查找是否包含关键字key是否在单链表当中
 public boolean contains(int key) {
     for (Node find = this.head; find != null; find = find.next) {
         if(find.val == key) {
             return true;
         }
     }
     return false;
  }
  //删除第一次出现关键字为key的节点
  public void remove(int key) {
      if(this.head.val == key) {
          this.head = this.head.next;
          this.head.prev = null;
          return;
      }
      Node find;
      for (find = this.head.next; find.next != null; find = find.next) {
          if(find.val == key) {
              find.next.prev = find.prev;
              find.prev.next = find.next;
              return;
          }
      }
      find.prev.next = null;
  }
  //删除所有值为key的节点
  public void removeAllKey(int key) {
      for(Node find = this.head; find != null; find = find.next) {
          if(find.val == key) {
              remove(key);
          }
      }
  }
  //得到单链表的长度
  public int size() {
      Node find = this.head;
      int count = 0;
      while (find!= null) {
          count ++;
          find = find.next;
      }
      return count;
  }
  public void display() {
      Node find = this.head;
      while (find != null) {
          System.out.print(find.val + " ");
          find = find.next;
      }
      System.out.println();
  }
  public void clear() {
      this.head = null;
  }
}

public class Review {
    public static void main(String[] args) {
        MyDoubleLinkedList myList = new MyDoubleLinkedList();
        myList.addFirst(30);
        myList.addFirst(20);
        myList.addLast(40);
        myList.addIndex(0, 10);
        myList.addIndex(4,60);
        myList.addIndex(4,50);
        myList.display();
        System.out.println(myList.contains(10));
        myList.remove(10);
        myList.remove(20);
        myList.remove(60);
        myList.display();
        myList.clear();
        System.out.println("===========");
        myList.display();
        int[] nums = new int[] {1,1,1,2,2,1,1,2,2,1,1,2,2,1,1,1,1,1,2,2,2,1,1,1,1};
        MyDoubleLinkedList mList2 = new MyDoubleLinkedList();
        for (int i:nums
             ) {
            mList2.addLast(i);
        }
        mList2.display();
        mList2.removeAllKey(1);
        mList2.display();
    }
}
