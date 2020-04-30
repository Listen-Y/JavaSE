/**
 * IO练习
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class aaa{
    public int a;
    public int b;

    public aaa(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "aaa{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

public class IOTest {



     public static String findNameByNum(String num) throws IOException {
         String name = "查无此人";
         FileReader fileReader = new FileReader("e:\\student.txt");
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         String tmep = bufferedReader.readLine();
         while (tmep != null) {
             String[] strings = tmep.split(",");
             System.out.println(strings[1].equals("张三"));
             if(strings[0].equals(num)) {
                 name = strings[1];
                 break;
             }
             tmep = bufferedReader.readLine();
         }
         bufferedReader.close();
         fileReader.close();
         return name;
     }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("e:\\MyCarPark.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String findCar = bufferedReader.readLine();
        System.out.println(findCar);
    }

    public static void main5(String[] args) {
         List<aaa> list = new ArrayList<>();
         aaa a = new aaa(1,1);
         list.add(a);
         list.add(new aaa(2,2));
         list.add(new aaa(3,3));
        System.out.println(Arrays.toString(list.toArray()));
        Object[] aaas = list.toArray();
        System.out.println(aaas[0]);

    }

    public static void main4(String[] args) throws IOException{
        //System.out.println(findNameByNum("000"));
        /*String s = "111,222,333";
        String[] strings = s.split(",");*/
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        //1
        System.out.println(Arrays.toString(list.toArray()));
        //2
        Object[] strings =  list.toArray();
        System.out.println(Arrays.toString(strings));
        //3
        String[] strings1 = (String[]) list.toArray();
        System.out.println(Arrays.toString(strings1));
    }

    public static void main2(String[] args) throws IOException {
        FileReader fileReader = new FileReader("e:\\student.txt");
        int br = fileReader.read();
        while (br != -1) {
            System.out.print((char) br);
            br = fileReader.read();
        }
        fileReader.close();
    }

    public static void main1(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("e:\\null.txt");
        fileWriter.write("001,李四，181");
        fileWriter.close();
    }
}
