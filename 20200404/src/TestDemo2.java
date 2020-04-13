/**
 * Cloneable接口吗  为什么他是一个空接口？
 *  空接口：标志接口--》如果一个类 实现了Cloneable接口 代表
 *  这个类可以被克隆。
 *
 *  第2步：重写Object的clone方法
 */
class Money implements Cloneable{
    public int money = 19;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;

    public Money m;

    public Person(int age) {
        this.age = age;
        m = new Money();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
    //alt+insert --》toString()

    //ctr+o     ==> Object的方法    可以自定义快捷键

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


   /* @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person1 = (Person) super.clone();
        person1.m = (Money) this.m.clone();
        return person1;
    }*/
}

public class TestDemo2 {

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);
        Person person1 = (Person) person.clone();

        System.out.println(person.m.money);//19
        System.out.println(person1.m.money);//19
        System.out.println("======================");
        person1.m.money = 99999;
        System.out.println(person.m.money);//
        System.out.println(person1.m.money);//
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Person[] people = new Person[2];
        people[0] = new Person(10);
        Person person1 = (Person) people[0].clone();

        System.out.println(people[0].age);//10
        System.out.println(person1.age);//10
        System.out.println("========通过person1修改age==========");
        person1.age = 999;
        System.out.println(people[0].age);//10
        System.out.println(person1.age);//999


        /*try {
            Person person1 = (Person) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
    }
}
