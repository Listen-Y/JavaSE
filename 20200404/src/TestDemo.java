/**
 * comparable cloneable toString
 */
class Id implements Cloneable{
    public int idNum;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Students implements Cloneable, Comparable<Students> {
    public int age;
    public String name;
    public Id num = new Id();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Students students = (Students) super.clone();
        students.num = (Id) this.num.clone();
        return students;
    }

    @Override
    public String toString() {
        return "Students{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", idNum=" + num.idNum +
                '}';
    }

    @Override
    public int compareTo(Students o) {
        return this.num.idNum - o.num.idNum;
    }
}

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException{
        Students student = new Students();
        student.age = 9;
        student.name = "aaa";
        student.num.idNum = 111;
        Students student1 = (Students) student.clone();
        student1.age = 99;
        student1.name = "bbb";
        student1.num.idNum = 222;
       /* System.out.println(student.age);
        System.out.println(student1.age);*/
        System.out.println(student.toString());
        System.out.println(student1.toString());
    }
}
