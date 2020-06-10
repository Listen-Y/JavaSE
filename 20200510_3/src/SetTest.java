import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("aaa");
        set.add("ccc");
        //有重复的set只保留一份
        System.out.println(set);
        //判断是否存在key
        System.out.println(set.contains("ccc"));
        //遍历方式 for each
        for (String str : set
             ) {
            System.out.print(str + " ");
        }
        System.out.println();
        //用迭代器进行遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.print(str + " ");
        }
    }
}
