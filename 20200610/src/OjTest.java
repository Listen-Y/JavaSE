public class OjTest {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
        //System.out.println(func(12, 6));
    }
    //求最大公约数 然后求最小公倍数就是将俩个数乘起来然后除他俩的最大公约数
    public static int func(int a, int b) {
        if (b == 0) return a;
        return func(b, a % b);
    }

    static class A {
        protected int value;
        public A(int v) {
            setValue(v);
        }
        public void setValue(int v) {
            this.value = v;
        }
        public int getValue() {
            try {
                value++;
                return value;
            }catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }
    }
}
