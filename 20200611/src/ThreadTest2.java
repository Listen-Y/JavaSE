public class ThreadTest2 {
    //懒汉模式
    static class Singal {

        private Singal() {
        }

        private volatile static Singal singal;

        public static Singal getSingal() {
            if (singal == null) {
                synchronized (Singal.class) {
                    if (singal == null) {
                        singal = new Singal();
                    }
                }
            }
            return singal;
        }
    }

    public static void main(String[] args) {

        Singal singal = Singal.getSingal();
        Singal singal1 = Singal.getSingal();
        System.out.println(singal == singal1);
    }
}
