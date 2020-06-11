import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String inStr = scan.next();
            String outStr = scan.next();
            inStr = inStr.toUpperCase();
            outStr = outStr.toUpperCase();
            Set<Character> outStrSet = new HashSet<>();
            //将俩个字符串都转成大写，然后将实际输出的字符串放入set中，
            //遍历输入的字符串，在set中进行判断，如果一个字符在set中就说明不是坏建，如果不在说明是坏件
            //但还要注意一个坏建输出过一次就不再输出
            for (int i = 0; i < outStr.length(); i++) {
                outStrSet.add(outStr.charAt(i));
            }
            Set<Character> retSet = new HashSet<>();
            for (int i = 0; i < inStr.length(); i++) {
                char c = inStr.charAt(i);
                if(outStrSet.contains(c)) {
                    continue;
                }
                if(retSet.contains(c)) {
                    continue;
                }
                System.out.print(c);
                retSet.add(c);
            }
            System.out.println();
            System.out.println("===============");
            System.out.println(retSet);
            System.out.println(retSet.toString());
            //Object[] chars = retSet.toArray(new char[]);
            //System.out.println(Arrays.toString(chars));
            for (char ch:retSet
                 ) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}