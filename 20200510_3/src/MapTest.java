import java.util.*;

class Student {
    public String name;
    public int agg;
    public String garde;
    public String schlool;

    static void h() {
        System.out.println("hh");
    }
    public Student(String name, int agg, String garde, String schlool) {
        this.name = name;
        this.agg = agg;
        this.garde = garde;
        this.schlool = schlool;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", agg=" + agg +
                ", garde='" + garde + '\'' +
                ", schlool='" + schlool + '\'' +
                '}';
    }
}
public class MapTest {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student student = new Student("Listen", 20, "001", "Happy");
        Student student1 = new Student("Listen", 30, "002", "Day");
        Student student2 = new Student("Byke", 40, "003", "Sun");
        Student student3 = new Student("Frake", 50, "004", "Mane");
        map.put(student.name, student);
        //如果有相同的key，新的value会覆盖旧的value
        map.put(student.name, student);
        map.put(student1.name, student1);
        map.put(student2.name, student2);
        map.put(student3.name, student3);
        //当前键值对是学生姓名=》学生对象
        String name = "Listen";
        Student ret =  map.get(name);
        map.remove(name);
        System.out.println(ret);
        System.out.println(map.get("mm"));
        System.out.println(map.getOrDefault("mm", new Student("mm", 50, "009", "shine")));
        //返回所有key的不重合集合
        Set<String> set = map.keySet();
        System.out.println(set);
        //返回所有value的集合可以重复
        System.out.println("------------------");
        Collection<Student> collections = map.values();
        System.out.println(collections);
        System.out.println("========================");
        //返回所有map的映射关系，并将它变成set里的key
        Set<Map.Entry<String, Student>> set1 = map.entrySet();
        //然后遍历set
        System.out.println(set1);
        System.out.println(map);
        System.out.println("=============");
        //遍历map
        for (Map.Entry<String, Student> m : map.entrySet()
             ) {
            System.out.println(m.getKey() + ":" + m.getValue());
        }
        //用迭代器遍历map
        System.out.println("=============");
        Iterator<Map.Entry<String, Student>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i : nums) {
            Integer tmp = map.get(i);
            if(tmp == null) {
                map.put(i,1);
            }else {
                map.put(i,tmp + 1);
            }

        }
        //map.put(i,map.getOrDefault(i,0) + 1);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
