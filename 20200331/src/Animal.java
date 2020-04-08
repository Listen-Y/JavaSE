public class Animal {
    public String name;
    public void eat() {
        System.out.println("Animal" + "  eatting");
    }
    public Animal(String name) {
        this.name = name;
    }

    public boolean equils(String str) {
        if(str.equals(this.name)) {
            return true;
        }else {
        return false;
        }
    }

    public void sleep () {
        System.out.println("sleeping");
    }
}
