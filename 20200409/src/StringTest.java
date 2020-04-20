import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String string = "hello world world";
        String string1 = " wor";

        //判断是否包含
        System.out.println(string.contains(string1));


        //indexof不光能判断存在不，还能返回子串所在的位置，不在返回-1
        System.out.println(string.indexOf(string1));
        System.out.println(string.lastIndexOf(string1));
        System.out.println(string.startsWith("hello"));
        System.out.println(string.endsWith("rld"));


        //replace没改变原来字符串，只是返回新字符串  regex 正则表达式
        String string2 = string.replaceAll("world", "Java");
        System.out.println(string);
        System.out.println(string2);


        //分割字符串 split
        String str1 = "aaa,bbb,,ccc";
        String[] strings = str1.split(",");
        System.out.println(Arrays.toString(strings));


        //.有特殊含义，若要.切就要转义\\. 用\\表示文本 如| * + ...都需要转义
        String str2 = "192.168.1.1";
        String[] strings1 = str2.split("\\.");
        System.out.println(Arrays.toString(strings1));

        String str3 = "name=张三&age=18&ID=201801010101";
        String[] strings2 = str3.split("&");
        //System.out.println(Arrays.toString(strings2));
        for (String tmp:strings2
             ) {
            String[] arr = tmp.split("=");
            System.out.println(Arrays.toString(arr));
        }

        //字符串截取 substring 前闭后开
        String str4 = "hello world";
        System.out.println(str4.substring(2,7));
        System.out.println(str4.substring(4));

        //trim 去掉左右俩边的空白字符
        String str5 = "  \n   abcd  \n  \t   ";
        System.out.println(str5);
        System.out.println(str5.trim());

        //大小写,返回的是新的字符串，未修改本身
        String str6 = "aaa";
        String ste7 = "BBB";
        System.out.println(str6.toUpperCase());
        System.out.println(ste7.toLowerCase());

        //builder 不安全  buffer  线程安全
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append('a');
        }
        stringBuilder.append('c');
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.reverse());
        System.out.println(stringBuilder.insert(0, 's'));


    }
}
