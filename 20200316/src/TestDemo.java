import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
       /* char s = 'A';
        s = (char)(s+1);
        System.out.println(s);*/
       /*String str = "ABCD";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        System.out.println(str.length());
*/
       /*int[] arr = new int[0];
       arr[0] = 1;
       arr[1] = 2;
        System.out.println(arr.length);*/

    }
    public calss TestDemo {

        public static void main(String[] args) {

            Car[] car = new Car[10];
            CarTeam carTeams = {car};

            for(int i= 0; i < car.length; i++) {

                System.out.println(car[i]);

            }

        }



        public static calss Car {

//类的属性

            public String carName;

            public String carNum;

            public String carColor;

            public int carMaxSpeed;

            public boolean carHealth;

//类的方法

            public void doWork {

                System.out.println("行驶中");

            }



            public void stop {

                System.out.println("停车中");

            }



            public void overSpeed {

                System.out.println("已超速");

            }



            public void carError {

                System.out.println("出故障");

            }



            public viod printAll {

                System.out.println("车名" + carName + " 车牌号" + carNum + " 车颜色"

                        + carColor + " 车最高速度" + carMaxSpeed + " 车状况" + carHealth);

            }

//构造方法

public Car() {

                System.out.print("车很漂亮");

            }



public Car(String carName, String carNum, String carColor, int carMaxSpeed, boolean carHealth) {

                carName = name;

                carNum = num;

                carColor = color;

                carMaxSpeed = speed;

                carHealth = health;

            }

        }

    }


    public static class CarTeam {
        //私有属性
        private Car[] carTeam;
        //方法
        public void setCarTeam(Car[] carTeam) {
            this.carTeam = carTeam;
        }

        public Car[] getCarTeam() {
            return carTeam;
        }
        //构造方法
        public CarTeam(Car[] carTeam) {
            setCarTeam(carTeam);
        }
    }
}
