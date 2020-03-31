abstract class  Car {
    private String carNum;
    private String brandName;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Car(String carNum, String brandName) {
        this.carNum = carNum;
        this.brandName = brandName;
    }

    public Car() {

    }

    public void start() {
        System.out.println(this.carNum + "启动");
    }

    public void stop() {
        System.out.println(this.carNum + "停止");
    }

    public abstract void addEnergy();
}

class oilCar extends Car {
    public void addEnergy() {
        System.out.println("加汽油");
    }
}
class GsCar extends Car {
    public void addEnergy() {
        System.out.println("加天然气");
    }

    public GsCar(String carNum, String brandName) {
        super(carNum, brandName);
    }
}



public class Absttuct {
    public static void main(String[] args) {
        GsCar car1 = new GsCar("A2222", "奔驰");
        car1.addEnergy();
    }
}
