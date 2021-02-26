package com.demo;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-10
 * Time: 10:32
 */
public class Test extends X {
    //3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
    Y y = new Y();

    public Test() {
        System.out.println("Z");
    }

    public static void main(String[] args) {
        new Test();
    }

}

class X {
    Y y = new Y();

    public X() {
        System.out.println("X");
    }
}

class Y {
    public Y() {
        System.out.println("Y");
    }
}


