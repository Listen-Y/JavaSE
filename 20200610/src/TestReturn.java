public class TestReturn {

    private static int test() {
        int num = 0;
        try {
            num++;
            System.out.println("try"+ " " + num);
            //int a = 2 / 0;
            return num;
        }catch (Exception e) {
            num++;
            System.out.println("catch"+ " " + num);
            return num;
        } finally {
            num++;
            System.out.println("finally"+ " " + num);
        }
    }

    private static int num = 2;

    public static void main(String[] args) {
        //System.out.println(test());
        System.out.println(Test.count);
    }
}
