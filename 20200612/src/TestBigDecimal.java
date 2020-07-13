import java.math.BigDecimal;

public class TestBigDecimal {
    //String double int char 都可以在BigDecimal的构造函数中使用
    private static String num = "12345678654.2345678976";
    private static double num1 = 999.999;

    public static void main(String[] args) {

        bigDecimalAdd();
        bigDecimalSub();
        bigDecimalMul();
        bigDecimalDivi();

    }

    public static void bigDecimalAdd() {

        BigDecimal bigDecimal = new BigDecimal(num);
        BigDecimal bigDecimal1 = new BigDecimal(num1);

        System.out.println(bigDecimal.add(bigDecimal1));
    }

    public static void bigDecimalSub() {
        BigDecimal bigDecimal = new BigDecimal(num);
        BigDecimal bigDecimal1 = new BigDecimal(num1);

        System.out.println(bigDecimal.subtract(bigDecimal1));
    }

    public static void bigDecimalMul() {
        BigDecimal bigDecimal = new BigDecimal(num);
        BigDecimal bigDecimal1 = new BigDecimal(num1);

        System.out.println(bigDecimal.multiply(bigDecimal1));
    }

    public static void bigDecimalDivi() {
        BigDecimal bigDecimal = new BigDecimal(num);
        BigDecimal bigDecimal1 = new BigDecimal(num1);

        BigDecimal bigDecimal2 = bigDecimal.add(bigDecimal1);
        //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
        bigDecimal2 = bigDecimal2.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal2.toString());
    }
}
