import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.IdentityHashMap;

/**
 * String   StringBuffer
 */
public class Test {
    public static void main(String[] args) {
        String num = "201806010101";
        System.out.println(getYaer(num));
        if(chexkIsDX(num)) {
            System.out.println("ok");
        }
        String IDNum = "000000199901011234";
        System.out.println(getBirthStrByIdNum(IDNum));
        String str = "中国最伟大";
        String st = "伟大";
        System.out.println(str.indexOf(st));
        System.out.println("5 + 3 = " + (3 + 5));//字符串对象+基本数据类型会暗自调用字符串的valueof
        System.out.println("5 + 3 = " + String.valueOf(3 + 5));
        String sss = "4";
        int aaa = Integer.parseInt(sss);
        System.out.println(aaa);
    }

    public static int getYaer(String num) {
        char[] chs = new char[4];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = num.charAt(i);
        }
        String year = new String(chs);//将字符数组转为字符串
        return Integer.parseInt(year);//将字符串转为数字
    }

    public static boolean chexkIsDX(String num) {
        String cStr = num.substring(4, 6);//取4位数字和5位数字
        if(cStr.equals("06")) {
            return true;
        }
        return false;
    }
    // "000000199901011234"
    public static StringBuffer getBirthStrByIdNum(String IDNum) {
        String birthYear = IDNum.substring(6, 10);
        String birthMon = IDNum.substring(10, 12);
        String birthDay = IDNum.substring(12, 14);
        StringBuffer str = new StringBuffer(birthYear);
        str.append("Year");
        if(birthMon.charAt(0) == '0') {
            str.append(birthMon.charAt(1));
        }else  {
            str.append(birthMon);
        }
        str.append("Mon");
        if(birthDay.charAt(0) == '0') {
            str.append(birthDay.charAt(1));
        }else {
            str.append(birthDay);
        }
        str.append("Day");
        return str;
    }
}
