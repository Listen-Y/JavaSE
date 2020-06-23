import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    public String name;
    public int age;
    public float grade;

    public Student(String name, int age, float grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}

//函数式接口
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}

@FunctionalInterface
interface MoreParameterReturn {
    int test(int a, int b);
}

@FunctionalInterface
interface NoParameterReturn {
    int test();
}

public class LambdaTest {
    public static void main1(String[] args) {
        //
        NoParameterNoReturn noReturn = () -> {
            System.out.println("无参无返回值");
        };
        noReturn.test();
        //
        MoreParameterReturn moreParameterReturn = (int a,int b) -> {
            return a+b;
        };
        int ret = moreParameterReturn.test(60,70);
        System.out.println(ret);
        //
        NoParameterReturn noParameterReturn = () -> 100;
        int ret1 = noParameterReturn.test();
        System.out.println(ret1);
    }


    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Listen", 10, 90));
        list.add(new Student("Bike", 20, 91));
        list.add(new Student("Franke", 30, 92));
        list.add(new Student("Linda", 40, 99));
        //for each
        for (Student s : list
             ) {
            System.out.print(s + " ");
        }
        System.out.println();
        //
        list.forEach(student -> {
            System.out.print(student +" ");
        });
        System.out.println();
        //sort()
        list.sort((o1, o2) -> o2.age - o1.age);
        System.out.println(list);
        //map
        Map<Integer, String>  map = new HashMap<>();
        map.put(1, "C");
        map.put(2, "Java");
        map.put(3, "Python");
        map.put(4, "PHP");
        //
        for (Map.Entry<Integer, String> entry : map.entrySet()
        ) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        //
        map.forEach( (k, v) -> System.out.println(k + "=" + v) );
    }
}
