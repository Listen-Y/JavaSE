public class TestClass {
       /* public static void main(String args[]){
            Test test = new Test();
            test.aMethod();
            int j = test.aMethod();
            System.out.println(j);
        }
    public class Test {
        public int aMethod(){
            static int i = 0;
            i++;
            return i;
        }
}*/

   /* public class  Test {
        public void hello() {
            System.out.println("hello");
        }
    }
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Test test = null;
            test.hello();
        }*/
   public class Test {
       public int aMethod(){
           static int i = 0;//错误
           i++;
           return i;
       }
       public static void main(String args[]){
           Test test = new Test();
           test.aMethod();
           int j = test.aMethod();
           System.out.println(j);
       }
   }
    }





