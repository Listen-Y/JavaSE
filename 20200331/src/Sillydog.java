public class Sillydog extends Dog {
    private String Color;

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Sillydog(String name, String kind, String Color) {
        super(name, kind);
        this.Color = Color;
    }

    public boolean equils(String name, String kind, String Color) {
        if(super.equils(name, kind)) {
            if(this.Color.equals(Color)) {
                return true;
            }else  {
                return false;
            }
        }else {
            return false;
        }
    }

    public void eat() {
        System.out.println(this.name + " SillyDog" + " eatting");
    }
}
