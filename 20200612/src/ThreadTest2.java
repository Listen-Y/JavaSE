
//懒汉模式 懒汉模式是在用到该实例的时候才去创建一个实例 后序再去创建实例只是返回原有实例 线程不安全
class LazySingle {

    private LazySingle() {

    }

    private volatile static LazySingle single;

    public  static LazySingle getSingle() {

        if (single == null) {
            synchronized (LazySingle.class) {
                if (single == null) {
                    single = new LazySingle();
                }
            }
        }

        return single;
    }
}

public class ThreadTest2 {

    public static void main(String[] args) {

        LazySingle single = LazySingle.getSingle();
        LazySingle single1 = LazySingle.getSingle();

        System.out.println(single == single1);
    }
}
