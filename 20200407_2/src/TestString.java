public class TestString{
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main1(String[] args){
        System.out.println(isAdmin("Admin"));
    }

    public static void main2(String[] args) {
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
    }

    String str = new String("good");
    char[ ] ch = { 'a' , 'b' , 'c' };
    public static void main3(String[] args){
        TestString ex = new TestString();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }

    public static int compareTo(String str1, String str2) {
        if(str1 == null && str2 == null) {
            return 0;
        }
        if(str1 == null) {
            return -1;
        }
        if(str2 == null) {
            return 1;
        }
        int lengthStr1 = str1.length();
        int lengthStr2 = str2.length();
        int length = Math.min(lengthStr1, lengthStr2);
        for (int i = 0; i < length; i++) {
            int answer = str1.charAt(i) - str2.charAt(i);
            if(answer != 0) {
                return answer;
            }
        }
        int num = Math.subtractExact(lengthStr1, lengthStr2);
        if(num < 0) {
            return -1;
        }else if(num == 0) {
            return 0;
        }else {
            return 1;
        }
    }

    public static void main(String[] args) {
       String str1 = "abcdff";
       String str2 = "abcdff";
        System.out.println(compareTo(str1, str2));
    }
}