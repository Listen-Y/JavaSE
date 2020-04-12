public class fish extends Animal implements ISwimming {
    public void eat() {
        System.out.println("fish eat little fish");
    }

    public void sleep() {
        System.out.println("fish sleep in walter");
    }

    public void swim() {
        System.out.println("fish can swim");
    }

    public fish(String name, String color) {
        super(name, color);
    }
}
