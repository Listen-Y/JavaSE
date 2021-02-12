import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-02-10
 * Time: 9:39
 */
public class Test {

    public static void main1(String[] args) {
        String[] nums = new String[] {"1", "2", "3"};
        String[] ints = Arrays.copyOf(nums, nums.length);
        nums[0] = "-1";
        System.out.println(Arrays.toString(ints));
    }

    static class Stu implements Cloneable{
        int age;
        String name;

        public Stu(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return this;
        }
    }

    public static void main2(String[] args) {
        Stu[] stu = new Stu[] {new Stu(22, "aa"), new Stu(99, "bb")};
        Stu[] stus = Arrays.copyOf(stu, stu.length);
        stu[0] = null;
        System.out.println(Arrays.toString(stu));
        System.out.println(Arrays.toString(stus));
        /**
         * 所以CopyOnWriteArrayList在修改数据的时候使用Array.copyof复制了一份数据给迭代器
         * 那么原来的集合中的数据被修改的时候是不会影响迭代器中的
         * Array.copyof是浅拷贝, 对于基本数据类型来说是深拷贝, 对于引用类型来说是浅拷贝,
         * 但是在使用CopyOnWriteArrayList我们只关注集合中数组中的数据的增删, 所以是引用的增删
         * 还是丝毫不影响拷贝中的数组中的数据
         */
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Stu stu = new Stu(11, "aa");
        Stu clone = (Stu) stu.clone();
        clone.name = "bb";
        System.out.println(stu);
        System.out.println(clone);

        System.out.println(stu.age + stu.name);
        System.out.println(clone.age + clone.name);
        /**
         * 实现Cloneable重写其clone方法克隆出来的对象时深拷贝
         */
    }
}
