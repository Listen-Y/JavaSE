import java.util.function.IntConsumer;

public class Demo {

    static class MyInConsumer implements IntConsumer {

        String result = "";

        @Override
        public void accept(int value) {
            result += String.valueOf(value);
        }
    }

    public static void main1(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);

        MyInConsumer myInConsumer = new MyInConsumer();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(myInConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(myInConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(myInConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(3000);

        System.out.println(myInConsumer.result);
    }

    public static void main2(String[] args) throws InstantiationException, IllegalAccessException {

        MyInConsumer myInConsumer = new MyInConsumer();
        MyInConsumer myInConsumer1 = fun(myInConsumer.getClass());
        System.out.println(myInConsumer1.hashCode());
        System.out.println(myInConsumer.hashCode());

    }

    public static <T> T fun(Class<T> data) throws IllegalAccessException, InstantiationException {
        return data.newInstance();
    }

    enum chars {
        aa,
        bb,
        cc
    }

    public static void main(String[] args) {
        System.out.println(chars.aa.equals(chars.valueOf("aa")));
        /**
         * 下面表示接受一个枚举中的常量
         */
        Enum<?> e = chars.aa;
        chars chars = Demo.chars.bb;
        System.out.println(e.equals(chars));

        /**
         * 下面用在方法返回值上，
         * 前一个表示返回直是一个范型 是T类型，后面参数或者方法里面的范性就用T就好
         * 第二种表示一个范性， 但是这个范性是枚举类型， T后面方法里遇到枚举范性就用T表示即可
         */
        // <T> T
        // <T extends Enum<T>> T

    }
}
