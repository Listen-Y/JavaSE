import java.time.chrono.IsoChronology;

public class Test {

    public static void swim(ISwimming iSwimming) {
        iSwimming.swim();
    }

    public static void run(IRunning iRunning) {
        iRunning.run();
    }

    public static void fly(IFlying iFlying) {
        iFlying.fly();
    }

    public static void walk(Iwalking iwalking) {
        iwalking.walk();
    }

    public static void main(String[] args) {
        ISwimming forg = new Forg("wawa", "black");
        ISwimming duck = new Duck("dudu", "write");
        forg.swim();
        duck.swim();
        System.out.println("======================");
        Forg forg1 = new Forg("YY", "red");
        fish fish = new fish("XX", "black");
        Duck duck2 = new Duck("LLL", "yellow");
        swim(forg1);
        swim(fish);
        swim(duck2);
        run(duck2);
        walk(forg1);
        fly(duck2);
        System.out.println("==============");
        Animal animal = new fish("anan", "red");
        Animal animal1 = new Duck("aaa", "ccc");
        animal.eat();
        animal1.eat();
        System.out.println(animal.getColor());
        Duck duck1 = new Duck("ccc", " sss");
        duck1.setKind("write sky duck");
        System.out.println(duck1.getKind());
    }
}
