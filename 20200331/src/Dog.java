public class Dog extends Animal{
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void kindAction() {
        System.out.println("kind different acttion different");
    }

    public Dog(String name, String kind) {
        super(name);
        this.kind = kind;
    }

    public boolean equils(String name, String kind) {
        if (super.equils(name)) {
            if(this.kind.equals(kind)) {
                return true;
            }else {
                return false;
            }
        }else  {
            return false;
        }
    }

    public void eat() {
        System.out.println(this.name + " Dog" + " eatting");
    }
}
