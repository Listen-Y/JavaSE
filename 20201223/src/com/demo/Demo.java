package com.demo;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-23
 * Time: 16:40
 */
public class Demo {

    private static String name = "bike"; //外部类的私有静态变量
    private int age = 10;    //外部类的私有属性

    private Stu play() {   //外部类的私有方法
        System.out.println("play");
        class Tea extends Stu {
            @Override
            public void print() {
                super.print();
                System.out.println("我是Tea执行的");
            }
        }
        return new Tea();
    }

    class Stu {   //内部类

        static String name;
        int age = 20;
        public void print() {
            System.out.println(age);  //20
            System.out.println(this.age);   //20
            //通过外部类名加this可以访问外部类的所有属性和方法
            System.out.println(Demo.this.age);   //10
            Demo.this.play();  //外部类的play方法
            Stu stu = Demo.this.new Stu();  //初始化内部类实例
            System.out.println(Demo.name);   //访问外部类的私有静态变量
        }
    }

    static class Per {
        static String name = "listen";
        int age = 30;

        public static void print() {
            System.out.println(name);
            //静态内部类访问外部类的私有静态属性
            System.out.println(Demo.name);
            //静态内部类访问外部类的普通属性
            System.out.println(Demo.this.age);  //报错了
        }
    }



    class Test {

    }



    public static void main(String[] args) {
        //实例化一个非静态内部类的时候需要先实例化外部类, 也就是需要实例化俩个对象
        Stu stu = new Demo().new Stu();


        Demo.Per per = new Demo.Per();
    }
}
