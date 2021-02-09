import java.util.*;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-27
 * Time: 21:54
 */
public class Demo {

    public static void main1(String[] args) {
        everyList();
        streamList();
    }

    /**
     * 传统遍历筛选操作
     */
    public static void everyList() {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //得到名字长度为3个汉字的集合
        List<String> list1 = new ArrayList<>();
        for (String name: list
             ) {
            if(name.length() >= 3) {
                list1.add(name);
            }
        }
        //得到姓为张的集合
        List<String> list2 = new ArrayList<>();
        for (String name: list1
        ) {
            if(name.startsWith("张")) {
                list2.add(name);
            }
        }

        System.out.println(list2);
    }

    /**
     * 新特性的遍历筛选操作
     */
    public static void streamList() {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream().filter(name -> name.length() >= 3)
                .filter(name -> name.startsWith("张")).forEach(System.out :: println);

        System.out.println(list);
    }

    public static void main2(String[] args) {
        List<String> list = new ArrayList<>();

        Stream<List<String>> list1 = Stream.of(list);

        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Vector<String> vector = new Vector<>();
        Stream<String> stream3 = vector.stream();
    }

    public static void main3(String[] args){
        Map<String,String> map = new HashMap<>();

        Stream<String> keyStream = map.keySet().stream();

        Stream<String> valueStream = map.values().stream();

        Stream<Map.Entry<String,String>> entrys = map.entrySet().stream();
    }

    public static void main4(String[] args){
        String[] array = {"私","忆","一","秒","钟"};

        Stream<String> stream = Stream.of(array);

        Arrays.stream(array).forEach(System.out :: println);
    }

    public static void main5(String[] args){
        Stream<String> stream = Stream.of("私","忆","一","秒","钟");
        stream.forEach(s->System.out.println(s));
    }

    public static void main6(String[] args){
        Stream<String> original = Stream.of("张无忌","张三丰","周芷若");
        Stream<String> result = original.filter(s->s.startsWith("张"));
    }

    public static void main7(String[] args){
        Stream<String> original = Stream.of("1","2","3");
        Stream<Integer> result = original.map(s->Integer.parseInt(s));
    }

    public static void main8(String[] args){
        Stream<String> stream = Stream.of("私","忆","一","秒","钟");
        Stream<String> stream2 = stream.limit(2);
        System.out.println(stream2.count());
    }

    public static void main9(String[] args){
        Stream<String> stream = Stream.of("私","忆","一","秒","钟");
        Stream<String> stream2 = stream.skip(2);
        System.out.println(stream2.count());
    }

    public static void main(String[] args){
        Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = original.filter(s->s.startsWith("张"));
        System.out.println(result.count());
    }
}
