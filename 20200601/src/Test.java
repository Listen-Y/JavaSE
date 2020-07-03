import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String A = in.nextLine();
            String B = in.nextLine();
            //获取第一行字符串的长度
            int length = A.length();
            //计数
            int count = 0;
            for (int i = 0; i <= length; i++) {
                StringBuffer sb = new StringBuffer();
                sb.append(A).insert(i, B);
                if (justHuiwen(sb)) {
                    count++;
                }

            }
            System.out.print(count);
        }
    }
    public static boolean justHuiwen(StringBuffer C){
        int i=0;
        int j=C.length()-1;
        while(i<j){
            if(C.charAt(i)!=C.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
