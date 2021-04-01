package com.demo;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-29
 * Time: 16:22
 */
public class OnlyOne {

    private static Object object;
    //懒汉模式
    public Object get() {
        if (object == null) {
            synchronized (this) {
                if (object == null) {
                    object = new Object();
                }
            }
        }
        return object;
    }

    //饿汉模式
    private static final Object object1 = new Object();

    public Object getObject1() {
        return object1;
    }

    public static void main(String[] args) {
        System.out.println(object);
        System.out.println(object1);
    }
}
