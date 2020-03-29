import java.util.Arrays;

class MyArrayList {
    private int[] array;
    private int arrayLength;
    private static int ARRAYLENGTH = 3;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public MyArrayList(int[] array) {
        this.array = array;
        this.arrayLength = array.length;
    }

    public MyArrayList() {
        this.array = new int[ARRAYLENGTH];
        this.arrayLength = 0;
    }

    // 打印顺序表
   public void display() {
       for (int i = 0; i < arrayLength; i++) {
           System.out.print(array[i] + " ");
       }
       System.out.println();
   }

   public boolean isFull() {
        if(arrayLength == ARRAYLENGTH) {
            return true;
        }
        return false;
   }
   // 在 pos 位置新增元素
   public void add(int pos, int data) {
        if(isFull()) {
            this.array = Arrays.copyOf(this.array, ARRAYLENGTH * 2);
            //throw new RuntimeException("FULL");
        }
        if(pos < 0 || pos > this.arrayLength ) {
            throw new ArrayIndexOutOfBoundsException("ERROE");
        }else{
            for(int i = this.arrayLength - 1; i >= pos; i --) {
                this.array[i + 1] = this.array[i];
            }
            this.array[pos] = data;
            this.arrayLength ++;
        }
   }
  // 判定是否包含某个元素
   public boolean contains(int toFind) {
       for (int i = 0; i < arrayLength; i++) {
           if(array[i] == toFind) {
               return true;
           }
       }
        return false;
    }
  // 查找某个元素对应的位置
   public int search(int toFind) {
       for (int i = 0; i < arrayLength; i++) {
           if(toFind == this.array[i]) {
               return i;
           }
       }
        return -1;
    }
   // 获取 pos 位置的元素
   public int getPos(int pos) {
       if(pos < 0 || pos > this.arrayLength - 1 ) {
           throw new ArrayIndexOutOfBoundsException("ERROE");
       }else {
           return this.array[pos];
       }
    }
  // 给 pos 位置的元素设为 value
   public void setPos(int pos, int value) {
       if(pos < 0 || pos > this.arrayLength - 1 ) {
           throw new ArrayIndexOutOfBoundsException("ERROE");
       }else {
           this.array[pos] = value;
       }
   }
  //删除第一次出现的关键字key
   public void remove(int toRemove) {
       for (int i = 0; i < arrayLength; i++) {
           if(this.array[i] == toRemove) {
               for (int j = i; j < arrayLength - 1; j++) {
                   this.array[j] = this.array[j + 1];
               }
               this.arrayLength --;
           }
       }
   }
  // 获取顺序表长度
   public int size() {
        return this.arrayLength;
    }
  // 清空顺序表
   public void clear() {
        this.arrayLength = 0;
   }

}

public class TestDemo {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.display();
        if(list.contains(10)) {
            System.out.println("ok");
        }
        System.out.println(list.search(20));
        System.out.println(list.getPos(2));
        list.setPos(1, 40);
        list.display();
        list.remove(40);
        list.display();
        System.out.println(list.size());
        System.out.println("====claer====");
        list.clear();
        list.display();
        System.out.println("扩容");
        int[] arr = new int[] {1,2,3};
        MyArrayList list1 = new MyArrayList(arr);
        list1.add(3, 4);
        list1.add(3, 4);
        list1.display();


    }
}
