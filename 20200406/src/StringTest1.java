
public class StringTest1 {

    public static void main(String[] args)
    {
        String num="201805010101";//定义一个用来表示学号的变量num
        System.out.println("该生的入学年份为:"+getYear(num)+"年");
        System.out.println(checkIsDX(num));
        String IDNum="61011220030512123X";
        System.out.println(getBirthStrByIDNum(IDNum));
    }

    //根据学号来返回入学年份 charAt
    public static int getYear(String num)
    {
        char[] chs=new char[4];
        //首先定义一个包含4个字符值的数组
        for(int i=0;i<chs.length;i++)
        {
            chs[i]=num.charAt(i);//将学号的第i个字符赋给字符数组的对应元素
        }
        String year=new String(chs);//用字符数组来创建一个字符串对象
        return Integer.parseInt(year);//将字符串对象通过整形的数据包装类的方法转化为整形值
    }

    //根据学号来判断是否是电信学院的学生
    public static boolean checkIsDX(String num)
    {
        String cStr=num.substring(4, 6);
        if(cStr.equals("06"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //根据输入的身份证号来返回一个字符串，例如"2002年7月13日出生"
    public static String getBirthStrByIDNum(String IDNum)
    {
        String year=IDNum.substring(6, 10);
        String month=IDNum.substring(10, 12);
        String day=IDNum.substring(12, 14);
        StringBuffer str=new StringBuffer(year);
        str.append("年");
        if(month.charAt(0)=='0')
        {
            str.append(month.charAt(1));
        }
        else
        {
            str.append(month);
        }
        str.append("月");
        if(day.charAt(0)=='0')
        {
            str.append(day.charAt(1));
        }
        else
        {
            str.append(day);
        }
        str.append("日");
        return str.toString();
    }

}
