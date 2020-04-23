/**
 *
 * 泛型类
 */

class A<T> {
    T value;
    //注意不能直接T[100]
    T[] ts = (T[]) new Object[100];

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
    void setTs(int index, T str) {
        this.ts[index] = str;
    }
    T getTs(int index) {
        return this.ts[index];
    }
}
public class HomeWork {
    public static void main(String[] args) {
        A<String> a = new A<>();
        a.set("aaa");
        System.out.println(a.get());
        A<Integer> a1 = new A<>();
        a1.setTs(0, 1);
        System.out.println(a1.getTs(0));
        a.setTs(0, "bbb");
        System.out.println(a.getTs(0));
       /* int i = 10;
        //自动装箱
        Integer ii = i;
        Integer ij = (Integer)i;
        //自动拆箱
        int j = i;
        int k = (int)i;*/
    }
}


