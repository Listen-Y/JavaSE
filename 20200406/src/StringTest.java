
public class StringTest {

    public static void main(String[] args) {

        String str="中国人民解放军";
        String subStr="解军";
        System.out.println(checkContainSubStr(str,subStr));
        System.out.println(str.contains(subStr));

        System.out.println("3+5="+(3+5));
        System.out.println("3+5="+String.valueOf(3+5));
        System.out.println("3+5="+3+5);
        System.out.println("3+5="+String.valueOf(3)+String.valueOf(5));
        System.out.println("2.1+3.2="+(2.1f+3.2f));
        String str1="abc ";
        String str2="def";
        System.out.println(str1+str2);

        System.out.println((str1+str2).trim());
        System.out.println(str1.trim()+str2);

        String stuInfo="001,张三,男,网络工程,2018年";
        String[] strs=stuInfo.split(",");
        for(int i=0;i<strs.length;i++)
        {
            System.out.println(strs[i]);
        }

        String IDNum="61011220031203345X";
        System.out.println("年龄为:"+(2020-Integer.parseInt(IDNum.substring(6, 10))));
    }

    //判断字符串中是否包含有某个子串
    //  中国人民解放军       人民
    public static boolean checkContainSubStr(String str,String subStr)
    {
        if(str.indexOf(subStr)>=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
