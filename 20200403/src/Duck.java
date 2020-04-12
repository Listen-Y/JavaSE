public class Duck extends Animal implements ISwimming, IRunning, Iwalking, IFlying {
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public void eat() {
        System.out.println("duck eat seed");
    }

    @Override
    public void sleep() {
        System.out.println("duck sleep on land");
    }

    @Override
    public void fly() {
        System.out.println("duck can fly");
    }

    @Override
    public void run() {
        System.out.println("duck can run");
    }

    @Override
    public void swim() {
        System.out.println("duck can swim");
    }

    @Override
    public void walk() {
        System.out.println("duck can walk");
    }

    public Duck(String name, String color) {
        super(name, color);
    }
}
