public class TestDemo {

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