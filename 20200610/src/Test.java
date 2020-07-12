public class Test {

    public static int count = 0;

    private static void methond() {
        System.out.println("MethondTest");
    }

    public static void main(String[] args) {
        String x = "fmn";
        x = x.toUpperCase();
        String y = x.replace('f', 'F');
        y = y + "wxy";
        System.out.println(y);
        //((Test)null).methond();
    }
}
