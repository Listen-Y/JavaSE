/**
 * 基础文档复习
 */

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Review {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> list1 = new LinkedList<>();
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list.addAll(list1);
        System.out.println(list);
    }

    public static void main4(String[] args) {
        int num = 30;
        System.out.println(Math.sin(30));
        System.out.println(num * Math.PI);
        System.out.println(Math.sqrt(30));
        System.out.println(Math.pow(30, 2));
        System.out.println(Math.addExact(num, 10));
        System.out.println(Math.subtractExact(num, 10));
    }


    public static void main3(String[] args) {
        Integer num = -13;
        String s = num.toString();
        System.out.println(s);
        System.out.println(Integer.max(num, 13));
        System.out.println(Integer.sum(num, 13));
    }

        public static void main2(String[] args) {
        char ch = (char) -13;
        System.out.println(ch);
        char ch1 = 13;
        //字符表示数子只表示了0~9
        System.out.println(ch1 - '0');
        Character ch2 = (char) -13;
        System.out.println(ch2 - '0');
        char ch3 = 65;
        System.out.println(ch3);
        //记住字符加减运算的如果不强制转换时候直接变为int了4个字节的了
        System.out.println((char)(ch3 + 32));
        System.out.println(ch3 + 32);
    }

    public static void main1(String[] args) {
        char a = '5';
        int num = '0' + a;
        System.out.println(num);
        String s = "abcdefgh";
        System.out.println(s.startsWith("cde", 2));
        System.out.println(s.indexOf("cde"));
        System.out.println(s.lastIndexOf("fg"));
        System.out.println(s.concat("ijk"));
        String s1 =  String.join("--", "java", "c++", "C");
        System.out.println(s1);
        String[] strings = s1.split("--");
        System.out.println(Arrays.toString(strings));
        System.out.println(s.toUpperCase());
        String s2 = "  . sdd  .  ";
        System.out.println(s2.trim());
        //字符串转数字 Integer.parseInt("-13") Integer.valueOf
        int ret1 = Integer.parseInt("-13");
        Integer ret = Integer.valueOf("-13");
        System.out.println(ret);
        //数字转字符串String.vauleof(-13)
        String s3 = String.valueOf(-13);
        System.out.println(s3);
    }

}
