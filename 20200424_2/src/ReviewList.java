import java.util.Arrays;

/**
 * 实现ArrayList 
 */

class MyArratList {
    private int[] array = new int[100];
    private  int length;

    // 打印顺序表
    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
// 在 pos 位置新增元素
     public void add(int pos, int data) {
        if(pos < 0 || pos > length) {
            return;
        }
        if(length == array.length) {
            return;
        }
        for(int i = length - 1; i >= pos; i --) {
            this.array[i + 1] = this.array[i];
        }
        this.array[pos] = data;
        length ++;
     }
 // 判定是否包含某个元素
     public boolean contains(int toFind) {
        for(int i = 0; i < length; i ++) {
            if(this.array[i] == toFind) {
                return true;
            }
        }
        return false;
    }
// 查找某个元素对应的位置
     public int search(int toFind) {
         for (int i = 0; i < length; i++) {
             if(this.array[i] == toFind) {
                 return i;
             }
         }
        return -1;
    }
 // 获取 pos 位置的元素
     public int getPos(int pos) {
        if(pos < 0 || pos >= length) {
            return -1;
        }
        return this.array[pos];
    }
// 给 pos 位置的元素设为 value
     public void setPos(int pos, int value) {
        if(pos < 0 || pos >= length) {
            return;
        }
        this.array[pos] = value;
     }
 //删除第一次出现的关键字key
     public void remove(int toRemove) {
        int index = 0;
         for (index = 0; index < length; index++) {
             if(this.array[index] == toRemove) {
                 break;
             }
         }
         if(index == length) {
             return;
         }
         for (int i = index; i < length - 1 ; i++) {
             this.array[i] = this.array[i + 1];
         }
         length --;
     }
 // 获取顺序表长度
      public int size() {
        return length; }
 // 清空顺序表
      public void clear() {
        this.length = 0;
      }
}

public class ReviewList {
    public static void main(String[] args) {
        MyArratList myArratList = new MyArratList();
        myArratList.add(0,1);
        myArratList.add(1,2);
        myArratList.add(2, 3);
        myArratList.add(100,4);
        myArratList.display();
        System.out.println(myArratList.contains(3));
        System.out.println(myArratList.contains(6));
        System.out.println(myArratList.getPos(2));
        System.out.println(myArratList.getPos(5));
        myArratList.remove(7);
        myArratList.remove(1);
        myArratList.display();
        System.out.println(myArratList.search(3));
        myArratList.setPos(0,100);
        myArratList.display();
    }
}
