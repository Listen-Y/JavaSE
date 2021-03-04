package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;


public class Demo {

    public static void main(String[] args) {
        Adx baidu = Adx.baidu;
        System.out.println(baidu.isDsp());
        Adx didi = Adx.didi;
        System.out.println(didi.isDsp());
    }

    public static void test() {
        ExecutorService pool = Executors.newScheduledThreadPool(3);
        pool.shutdown();
        pool.shutdownNow();
    }

    public void test2() {
        Supplier<String> stringSupplier = () -> null;

        String name = ((Supplier<String>) () -> {
            return "aa";
        }).get();

    }

    public void test3() {
    }


}
