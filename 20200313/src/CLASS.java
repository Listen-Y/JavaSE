import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Arrays;
import java.util.Scanner;

public class CLASS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--------MyClass------------");
            Student stu = new Student("YaYa", 18, "man", "201806xxxx");
            Student stu2 = new Student("陈钰琪",18, "girl","201806xxxx");
            Student[] students = new Student[2];
            students[0] = new Student("iU", 18, "girl", "201806xxxx");
            students[1] = new Student("鞠婧祎", 18, "girl", "201806xxxx");
            MyClass myClass = new MyClass(stu, stu2, students);
           /* System.out.print("班长信息:" + myClass.getMonitor().getStuName() + " " + myClass.monitor.getStuAge()
            + " " + myClass.monitor.getStuSex() + " " + myClass.monitor.getStuNum());*/
                System.out.println("班长信息:");
                myClass.monitor.printAll(myClass.monitor);
                System.out.print("状态：");
                stu.study();
                myClass.universityTwo();
        System.out.println();
        System.out.println("团支书信息:");
        myClass.lump.printAll(myClass.lump);
        System.out.print("状态：");
        stu2.doHomework();
        myClass.universityTwo();
        System.out.println();
            System.out.println("班级成员信息:");
            for (int i = 1; i < myClass.students.length + 1; i++) {
            System.out.println("成员 " + i + " :");
            myClass.students[i - 1].printAll(students[i - 1]);
            }
    }

    public static class Student {
        //类的私有属性
        private String stuName;
        private int stuAge;
        private String stuSex;
        private String stuNum;
        //类的方法
        public void printAll(Student stu) {
            System.out.println("姓名是：" + stuName);
            System.out.println("年龄是：" + stuAge);
            System.out.println("性别是：" + stuSex);
            System.out.println("学号是：" + stuNum);
        }

        public void study() {
            System.out.print(" 在学习");
        }

        public void doHomework () {
            System.out.print(" 写作业");
        }

        public void test() {
            System.out.print(" Testing");
        }

        //私有属性的构造和获取
        public void setStuName (String stuName) {
            this.stuName = stuName;
        }

        public String getStuName() {
            return stuName;
        }

        public void setStuAge(int stuAge) {
            this.stuAge = stuAge;
        }

        public int getStuAge() {
            return stuAge;
        }

        public void setStuSex(String stuSex) {
            this.stuSex = stuSex;
        }

        public String getStuSex() {
            return stuSex;
        }

        public void setStuNum(String stuNum) {
            this.stuNum = stuNum;
        }

        public String getStuNum() {
            return stuNum;
        }

        //类的构造方法
        public Student(String stuName, int stuAge, String stuSex, String stuNum) {
            setStuName(stuName);
            setStuAge(stuAge);
            setStuSex(stuSex);
            setStuNum(stuNum);
        }
    }

    public static class MyClass{
        //私有属性
        private Student monitor;
        private Student lump;
        private Student[] students;
        //方法
        public void universityOne() {
            System.out.print(" 大一");
        }

        public void universityTwo() {
            System.out.print(" 大二");
        }
        //私有属性的set和get
        public void setMonitor(Student monitor) {
            this.monitor = monitor;
        }

        public Student getMonitor() {
            return monitor;
        }
        public void setLump(Student lump) {
            this.lump = lump;
        }

        public Student getLump() {
            return lump;
        }

        public void setStudents(Student[] students) {
            this.students = students;
        }

        public Student[] getStudents() {
            return students;
        }
        //构造方法
        public MyClass(Student monitor, Student lump, Student[] students) {
            setMonitor(monitor);
            setLump(lump);
            setStudents(students);
        }

        
    }
}

/*
public class CLASS {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,6,5,4,3,2,1};
        for(int i= 1; i<arr.length; i++) {
            arr[0] = arr[0] ^ arr[i];
        }
        System.out.println("答案为:" + arr[0]);
    }
}
*/

/*//for each
for(int i  : arr) {//i代表每个元素的值
    sout(arr[i]);
}*/

/*sout(Arrays.toString(arr));
* */
