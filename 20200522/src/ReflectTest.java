import com.sun.org.apache.xpath.internal.objects.XObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Stuent {
    private String name = "Listen";
    public int age = 10;

    private Stuent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Stuent() {

    }

    public Stuent(String name) {
        this.name = name;
    }

    private void play(String game) {
        System.out.println(this.name + " 在玩" + game);
    }

    public void eat(String food, String food2) {
        System.out.println(this.name + " 在吃" + food + food2);
    }

    @Override
    public String toString() {
        return "Stuent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ReflectTest {

    //利用反射调用公有构造方法创建对象
    public static void reflectNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> classStudent = Class.forName("Stuent");
        //注意newInstance里传入的参数
        Object sudentInstance = classStudent.newInstance();
        Stuent stuent = (Stuent) sudentInstance;
        System.out.println(stuent);
        //第二种
        Stuent stuent1 = (Stuent) classStudent.newInstance();
        System.out.println(stuent1);
        //第三种
        Constructor<?> constructor = classStudent.getDeclaredConstructor(String.class);
        Stuent stuent2 = (Stuent) constructor.newInstance("Bike");
        System.out.println(stuent2);
    }

    //通过反射调动私有构造方法创建对象
    public static void reflectPrivateConstructor() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> sutndetClass = Class.forName("Stuent");
        Constructor<?> studentConstructor= sutndetClass.getDeclaredConstructor(String.class, int.class);
        //获得权限，破坏private封装
        studentConstructor.setAccessible(true);
        Stuent stuent = (Stuent) studentConstructor.newInstance("Bike", 20);
        System.out.println(stuent);
    }

    //反射私有属性
    public static void  reflectPrivateField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> studentCalss = Class.forName("Stuent");
        Field field = studentCalss.getDeclaredField("name");
        //获得破坏private封装的权限
        field.setAccessible(true);
        Stuent stuent = new Stuent();
        //可以通过set来修改，也可以通过get来获取
        System.out.println(stuent);
        field.set(stuent,"Frake");
        String name = (String) field.get(stuent);
        System.out.println(name);
    }

    //反射私有方法
    public static void reflectPrivateMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> studentClass = Class.forName("Stuent");
        Method method = studentClass.getDeclaredMethod("play", String.class);
        //破坏private权限
        method.setAccessible(true);
        Stuent stuent = new Stuent();
        method.invoke(stuent, " Baketball");
        //如果不是私有方法
        Method method1 = studentClass.getDeclaredMethod("eat", String.class, String.class);
        method1.invoke(stuent, " Apple", " Banana");
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        reflectNewInstance();
        System.out.println("=============");
        reflectPrivateConstructor();
        System.out.println("=============");
        reflectPrivateField();
        System.out.println("=============");
        reflectPrivateMethod();
    }
}
