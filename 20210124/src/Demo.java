import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-24
 * Time: 13:21
 */
public class Demo {

    public static void main1(String[] args) {
        Student student1 = new Student("Listen", 22);
        Student student2 = new Student("Listen", 22);
        System.out.println(student1.equals(student2));
        System.out.println("student1.hashCode() = " + student1.hashCode());
        System.out.println("student2.hashCode() = " + student2.hashCode());

        System.out.println("=========");
        Set<Student> set = new HashSet<>();
        set.add(student1);
        set.add(student2);

        System.out.println(set.size());
    }

    public static void main(String[] args) {
        Student student = new Monitor("ll", 11);
        student.play();
    }
}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void play() {
        System.out.println("play");
    }

    /**
     * 重写equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (! (obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;
        return student.name.equals(this.name) && student.age == this.age;
    }

    /**
     * 重写hashCode方法
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode()) + this.age;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Monitor extends Student {



    public Monitor(String name, int age) {
        super(name, age);
    }


    /**
     * 静态方法在子类和父类中都有, 但是不会有多态性
     */
    public static void play() {
        System.out.println("22");
    }

}
