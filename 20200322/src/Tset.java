/*public class Tset {
    static boolean Paddy;
    public static void main(String args[]){
        System.out.println(Paddy);
    }
}*/

/*import java.util.Scanner;

 class Calculator {
    private int num1;
    private int num2;
    private static int num3;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        return num1 + num2;
    }

    public int minus() {
        return num1 - num2;
    }

    public int ride() {
        return num1 * num2;
    }

    public float remove() {
        return  (float)num1 / num2;
    }

    public Calculator() {

    }

    public Calculator(int num1, int num2) {
        setNum1(num1);
        setNum2(num2);
    }

}
public class Tset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("利用第一种构造方法" + " new Calculator()");
        Calculator cal = new Calculator();
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        cal.setNum1(num1);
        cal.setNum2(num2);
        System.out.println(cal.remove());
        System.out.println("利用第二种构造方法" + " new Calculator(4,7)");
        Calculator cal2 = new Calculator(4,7);
        System.out.println(cal2.ride());
    }
}*/

/*
import java.util.Arrays;

public class Tset {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,6,4,3,8,7,6,4,9,3,5};
         function(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void function(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            while (low < high && arr[low] % 2 != 0) {
                low ++;
            }
            while (low < high && arr[high] % 2 ==0) {
                high --;
            }
            int tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
        }
    }
}
*/

/*import java.util.Arrays;

public class Tset {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1,1,1,1,1,1};
        int[] arr2 = new int[] {2,2,2,2,2,2};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int[] tmp = exchangeArrays(arr1, arr2) ;
        arr2 = exchangeArrays(arr2, arr1);
        arr1 = tmp;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] exchangeArrays(int[] arr1, int[] arr2) {
        return arr1 = arr2;
    }*/

/*    public static void main(String[] args) {
        int[] arr = new int[2];
        fun(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void fun(int[] arr) {
        arr[0] = 1;
        arr[1] = 2;
    }*/

