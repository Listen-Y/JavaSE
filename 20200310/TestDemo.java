/*public class TestDemo {

	public static void main(String[] args) {
		int[] arr1 = new int[10];
		Student[] students = new Student[10];
		int[][] arr = {{0},{0}};
		for(int i= 0; i < students.length; i ++) {
			students[i] = new Student();//对象引用
		}  
		for(int i = 0; i < students.length; i ++) {
			System.out.println("students[" +i+ "]" + "=" + students[i]);
		}

	}
	public  static class Student {
		public String name = "0";
		public String sex = "0";
		public  int age = 0;
	}
}
*/
/*public class Teacher {
	//属性
	public String name;
	public int age;
	public String sex;
    //
	public void odWork(); {
	    System.out.print("在上课");
	}
	public void overWork(); {
		System.out.print("下课");
	}

	public Teacher(String name, int age, String sex) {
		name = n;
		age = a;
		sex = s;
	}
}*/

public calss TestDemo {
	public static void main(String[] args) {
		Car[] car = new Car[10] = {new Car(),new Car(), new Car(), new Car(), new Car(),
		new Car(),new Car(),new Car(),new Car(),new Car() };
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