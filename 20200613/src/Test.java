public class Test {

   static class HelloTest {
       private String name;

       public HelloTest(String name) {
           this.name = name;
       }

       public void Hello() throws InterruptedException {

           System.out.println("hello begin");
           synchronized (this) {
               if (! "hello".equals(this.name)) {
                   this.wait();
               }
           }
           System.out.println("hello over");
       }

       public void makeHello() {

           System.out.println("makeHello begin");
           synchronized (this) {
               this.notify();
           }
           System.out.println("makeHello over");
       }
   }

    public static void main(String[] args) throws InterruptedException {
       HelloTest test = new HelloTest("no");
       Thread t1 = new Thread() {
           @Override
           public void run() {
               try {
                   test.Hello();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       };
       t1.start();

       Thread t = new Thread() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               test.makeHello();
           }
       };
       t.start();

    }
}
