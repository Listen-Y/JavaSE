import java.rmi.activation.ActivationInstantiator;
import java.util.Scanner;
import java.lang.Math;
import java.util.stream.StreamSupport;
/*

public class Test {
    public static void main(String[] args) {
        Student student = new Student("li", 2, "man");
        System.out.println(student);


    }
    public class Student {
        //私有属性
        private String stuName;
        private int stuAge;
        private String stuSex;
        //私有属性的访问方法
        public void setStuName(String stuName) {
            if(stuName.length < 12) {
                this.stuName = stuName;
            }
        }

        public String getStuName() {
            return stuName;
        }

        public void setStuAge(int stuAge) {
            if(stuAge < 6)
            this.stuAge = stuAge;
        }

        public int getAtuAge() {
            return stuAge;
        }

        public void setStuSex(String stuSex) {
            if(stuSex == "man" || stuSex == "girl")
            this.stuSex = stuSex;
        }

        public String getStuSex() {
            return stuSex;
        }
    }

}
*/

/*
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.println("输入二次函数的a,b,c,d (a不可为0)");
            float a = scan.nextFloat();
            float b = scan.nextFloat();
            float c = scan.nextFloat();
            float d = scan.nextFloat();
        while(a == 0) {
            System.out.println("a不可为0，重新输入a的值");
            a =scan.nextFloat();
        }
        solveFunction(a, b, c - d);
    }

    public static void solveFunction(float a, float b, float c) {
        float key = solveKey(a, b, c);
        System.out.println("答案为: ");
        if(key == 0) {
            System.out.println("此方程只有一个解: " + b / (a * -2));
        }else if(key > 0){
            printAnsewr(a, b, key);
        } else {
            System.out.println("此方程无解");
        }
    }

    public static float solveKey(float a, float b, float c) {
        return (b * b) - (4 * a * c);
    }

    public static void printAnsewr(float a, float b, float key) {
        System.out.println("X1 = " + (b + Math.sqrt(key))/(- 2 * a));
        System.out.println("X2 = " + (b - Math.sqrt(key))/(- 2 * a));
    }
}
*/

/*public class Test {
    public static void main(String[] args) {
        int a = 4;
        float b = 3.3245f;
        System.out.println(a > b ? a:b);
    }
}*/

/*
public class Test {
    public static void main(String[] args) {
        System.out.println("输入数字的个数为：");
        Scanner sc = new Scanner (System.in);
        int k = sc.nextInt();
        if(k==2){
            System.out.println("输入数字：");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int num1 = max( a , b );
            System.out.println("最大值为："+num1);
            double c = sc.nextDouble();
            double d = sc.nextDouble();
            double num2 = max( c , d );
            System.out.println("最大值为："+num2);
        }else if (k==3){
            System.out.println("输入数字：");
            double e = sc.nextDouble();
            double f = sc.nextDouble();
            int g = sc.nextInt();
            double num3 = max( e , f , g );
            System.out.println("最大值为："+num3);
        }

    }
    public static int max(int a, int b){
        int i = a>b?a:b;
        return i ;
    }
    public static double max(double a, double b){
        double i = a>b?a:b;
        return i ;
    }
    public static double max(double e, double f, int g){
        double i = max(e,f)>g ? max(e,f):g;
        return i ;
    }
}*/

/*
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入数字");
        int input = scan.nextInt();
        function(input);
    }

    public static void function(int num) {
        if(num < 10) {
            System.out.println(" " + num % 10);
        }else {
            System.out.print(" " + num %10);
             function(num /10);
        }
    }
}*/

/*
public class Test {
    public static void main(String[] args) {
        int ret = numAddNum(10);
        System.out.println(ret);
    }

    public static  int numAddNum(int num) {
        if(num == 1) {
            return 1;
        }else {
            return num + numAddNum(num - 1);
        }
    }
}
*/

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        System.out.println(addNum(input));
    }

    public static int addNum(int num) {
        if(num <10) {
            return num % 10;
        }else {
            return num % 10 + addNum(num / 10);
        }
    }
}
