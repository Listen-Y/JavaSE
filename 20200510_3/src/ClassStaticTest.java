/**
 * 内部类可以是静态的也可以是非静态的，静态的内部类才能有静态方法，,方法（无论静态非静态）里只能有内部类，不能有静态内部类
 */
public class ClassStaticTest {

    static void doStuff(Shape s){
        Shape.draw();
    }
    public static void main(String[] args){
        Circle c = new Circle();
        Triangle t = new Triangle();
        doStuff(c);
        doStuff(t);
        Circle.draw();
        Triangle.draw();
    }
     static class Shape{
         static void draw(){
            System.out.println("Shape Drawing");
        }
    }
    static class Circle extends Shape{
        static void draw(){
            System.out.println("Circle drawing");
        }
    }

    static class Triangle extends Shape{
        static void draw(){
            System.out.println("Triangle drawing");
        }
    }
}