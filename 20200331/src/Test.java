/**
 *
 * 继承、动态绑定练习
 */
public class Test {
    public static void main(String[] args) {
        Animal dog = new Sillydog("pig", "silly", "black");
        Animal dog1 = new Dog("pigg", "write");
        dog.eat();//动态绑定
        dog1.eat();
        dog.sleep();
        Dog dog3 = new Dog("piggg", "smart");
        //dog1.kindAction
        dog3.kindAction();
        Sillydog dog2 = new Sillydog("pig", "black", "black");
        if (dog2.equils("pig", "blac", "black")) {
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
        dog2.sleep();
    }
}
