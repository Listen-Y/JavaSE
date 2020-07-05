interface TuXin {
    float mianJi(int L, int W);
    float zhouChang(int L, int M);
}

class ZhenFangX implements TuXin {

    @Override
    public float mianJi(int L, int W) {
        return 0;
    }
    public float mainJi(int L) {
        return L * L;
    }

    @Override
    public float zhouChang(int L, int M) {
        return 0;
    }

    public float zhouChang(int L) {
        return 4 * L;
    }

}

class ChangFaX implements TuXin{

    @Override
    public float mianJi(int L, int W) {
        return L * W;
    }

    @Override
    public float zhouChang(int L, int M) {
        return 2 * (L + M);
    }
}

class Circle {

    public double mianJi(int R){
        return Math.PI * (R * R);
    }


    public double zhouChang(int R) {
        return 2 * Math.PI * R;
    }

    public void Circle() {
        System.out.println("circle");
    }
}



public class TestClass {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.Circle();
    }

}
