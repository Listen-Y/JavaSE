import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-21
 * Time: 15:53
 */
public class Demo {

    public static void main1(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
/*        String num1 = "99999991199";
        String num2 = "1";
        System.out.println(addStr(num1, num2));
        StringBuilder builder = new StringBuilder();
        StringBuilder reverse = builder.reverse();*/

    }

    public static void main(String[] args) {
        String num1 = "9999999.999999";
        String num2 = "111.111";
        Object o = new Object();
        System.out.println(o.equals(o));
        int i = o.hashCode();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
    }


    public String addBigNum(String num1, String num2) {
        if (num1.contains(".") && num2.contains(".")) {
            String[] parts1 = num1.split("/.");
            String[] parts2 = num2.split("/.");
            String integer = addIntegerStr(parts1[0], parts2[0]);
            String decimal = addDecimalStr(parts1[1], parts2[1]);
            return integer + "." + decimal;
        } else {
            return addIntegerStr(num1, num2);
        }
    }

    public static String addIntegerStr(String num1, String num2) {
        char[] char1 = new char[num1.length()];
        char[] char2 = new char[num2.length()];
        int index = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            char1[index++] = num1.charAt(i);
        }
        index = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            char2[index++] = num2.charAt(i);
        }
        int index1 = 0;
        int index2 = 0;
        int ans = 0;
        StringBuilder builder = new StringBuilder();
        while (index1 < char1.length && index2 < char2.length) {
            int temp = char1[index1++] - '0' + char2[index2++] - '0' + ans;
            ans = 0;
            if (temp >= 10) {
                ans = 1;
                temp %= 10;
            }
            builder.append(temp);
        }
        ans = getAns(char1, index1, ans, builder);
        ans = getAns(char2, index2, ans, builder);
        if (ans != 0) {
            builder.append(ans);
        }
        return builder.reverse().toString();
    }

    private static int getAns(char[] char2, int index2, int ans, StringBuilder builder) {
        while (index2 < char2.length) {
            int temp = char2[index2++] - '0' + ans;
            ans = 0;
            if (temp >= 10) {
                ans = 1;
                temp %= 10;
            }
            builder.append(temp);
        }
        return ans;
    }

    public static String addDecimalStr(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int index1 = 0;
        int index2 = 0;
        int ans = 0;
        StringBuilder builder = new StringBuilder();
        while (index1 < char1.length && index2 < char2.length) {
            int temp = char1[index1++] - '0' + char2[index2++] - '0' + ans;
            ans = 0;
            if (temp >= 10) {
                ans = 1;
                temp %= 10;
            }
            builder.append(temp);
        }
        ans = getAns(char1, index1, ans, builder);
        ans = getAns(char2, index2, ans, builder);
        if (ans != 0) {
            builder.append(ans);
        }
        return builder.reverse().toString();
    }


}
