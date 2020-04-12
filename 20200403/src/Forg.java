public class Forg extends Animal implements Iwalking, IRunning, ISwimming {
    @Override
    public void eat() {
        System.out.println("forg eat small animals");
    }

    @Override
    public void sleep() {
        System.out.println("forg sleep on leaf");
    }

    @Override
    public void run() {
        System.out.println("forg can run");
    }

    @Override
    public void swim() {
        System.out.println("forg can swim");
    }

    @Override
    public void walk() {
        System.out.println("forg can walk");
    }

    public Forg(String name, String color) {
        super(name, color);
    }
}
