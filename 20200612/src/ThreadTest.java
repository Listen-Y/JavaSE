
//饿汉模式 饿汉模式就是在类加载的时候就将唯一的实例创建好 线程安全 但是低效率
class HungrySingle {

    private HungrySingle() {

    }

    private static HungrySingle single = new HungrySingle();

    public static HungrySingle getSingle() {
        return single;
    }
}

public class ThreadTest {

    public static void main(String[] args) {

        HungrySingle single = HungrySingle.getSingle();
        HungrySingle single1 = HungrySingle.getSingle();
        System.out.println(single == single1);
    }
}
