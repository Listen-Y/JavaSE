import java.util.Arrays;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte N = scan.nextByte();
        int[] catFood = new int[N];
        for (int i = 0; i < N; i++) {
            catFood[i] = scan.nextInt();
        }
        byte H = 0;
        do {
            H = scan.nextByte();
            if(H < N) {
                System.out.println("错误举例，时间必须大于堆数!");
            }else {
                break;
            }
        }while(true);
        int n = eatSpeed(catFood, H);
        System.out.println(n);
    }

    public static int eatSpeed(int[] catFood, byte H) {
        byte speed = 0;
        for (speed = 0; ; speed ++) {
            byte count = 0;
            int[] catFoodCopy = Arrays.copyOf(catFood, catFood.length);
            for (int i = 0; i < catFoodCopy.length && count != H; i++) {
                while (catFoodCopy[i] > 0) {
                    catFoodCopy[i] -= speed;
                    count ++;
                    if(count == H) {
                        break;
                    }
                }
            }
            if(arraysAdd(catFoodCopy) == 0) {
                break;
            }
        }
        return speed;
    }

    public static int arraysAdd(int[] arr) {
        int sum = 0;
        for (int i: arr
             ) {
            if(i < 0) {
                i =0;
            }
             sum += i;
        }
        return sum;
    }
}
