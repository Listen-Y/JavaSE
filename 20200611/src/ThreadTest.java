
//饿汉模式
class SignalHungry {

    private SignalHungry() {
    }

    private static SignalHungry signal = new SignalHungry();

    public static SignalHungry getSignal() {
        return signal;
    }
}

public class ThreadTest {

    public static void main(String[] args) {

        SignalHungry signal = SignalHungry.getSignal();
        SignalHungry signal1 = SignalHungry.getSignal();
        System.out.println(signal == signal1);

        final SignalHungry[] signal2 = new SignalHungry[1];
        SignalHungry signal3;

        Thread t = new Thread() {
            @Override
            public void run() {
                signal2[0] = SignalHungry.getSignal();
            }
        };
    }
}
