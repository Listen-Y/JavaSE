import java.util.HashMap;
import java.util.Map;


class Solution {
    int[] array = new int[100];
    public int firstUniqChar(String s) {
        if(s == null) {
            return -1;
        }
        //利用map统计，返回第一个统计结果为1 的字符
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            Integer tmp = map.get(s.charAt(i));
            if(tmp == 1) {
                return i;
            }
        }
        return -1;
    }

    public int hashFunc(int key) {
        return 2 * key - 1;
    }

    public int hashFunc1(int key) {
        return key % this.array.length;
    }
}

class Cat {
    public String name;
    public int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("Eating");
    }
}

public class OjTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //Map<Character, Integer> map = new HashMap<>();
        //第一种或得class对象的方法，根据实例化对象获得class对象
        Cat cat = new Cat("AAA", 10);
        Class c1 = cat.getClass();
        //第二种，通过类的隐藏静态变量获得class对象，所以每一个类都会有一个隐藏的静态成员变量class
        Class c2 = Cat.class;
        //第三种，通过路径获得class对象,注意forName输入的字符串是类的全路径，如果有包得加的路径
        //第三种有好处就是在编译的时候不用知道类名
        Class c3 = Class.forName("Cat");
        //因为Class对象在方法区存储，所以一个class对象只能有一个
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);
        System.out.println("==================");
        Class c = Class.forName("Solution");
        System.out.println(c == c1);
    }
}
