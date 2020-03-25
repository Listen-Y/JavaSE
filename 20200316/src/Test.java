import javax.swing.*;
/* int[] arr = new int[] {3,5,3,3,2,45,6,8,9,8,6,54,6,7,43,3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));*/
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
       forReady();
    }

    public static void forReady() {
        Scanner scan = new Scanner(System.in);
        System.out.println("========学生人数========");
        int students = scan.nextInt();
        System.out.println("========题的数目========");
        int questions = scan.nextInt();
            System.out.println("========标准答案========");
            String rightAnswers = scan.next();
        int[] grads = new int[students];
        String[] s = new String[students];
        System.out.println("========学生答案========");
        for (int i = 0; i < students; i++) {
            int j = i + 1;
            System.out.print(j + "号学生答案为: ");
             s[i] = scan.next();
        }
        System.out.println("========得分统计========");
        for (int i = 0; i < students; i++) {
            grads[i] = getStudentsGrad(s[i], rightAnswers);
            int j = i + 1;
            System.out.println(j + "号学生得分为: " + grads[i]);
        }
        System.out.println("========优秀名单========");
        int[] bestGradSub = findBestGrads(grads);
        System.out.println("成绩最高的人数为: " + bestGradSub.length);
        System.out.println("分别为: ");
        for (int i: bestGradSub
             ) {
            int j = i + 1;
            System.out.println(j + "号学生" + " 成绩:" + grads[i] + " 答案:" + s[i]);
        }


    }
    public static  int getStudentsGrad(String s, String rightAnswers) {
        int grad = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == rightAnswers.charAt(i)) {
                 grad += 1;
            }
        }
        return grad;
    }

    public static int[] findBestGrads(int[] grad) {
        int[] gClone = Arrays.copyOf(grad, grad.length);
        Arrays.sort(gClone);
        int count = 0;
        for (int i = 0; i < grad.length; i++) {
            if(grad[i] == gClone[gClone.length - 1]) {
             count ++;
            }
        }
        int[] arraysBestGrads = new int[count];
        int j = 0;
        Arrays.sort(gClone);
        for (int i = 0; i < grad.length; i++) {
            if(grad[i] == gClone[gClone.length - 1]) {
                arraysBestGrads[j] = i;
                j++;
            }
        }
        return arraysBestGrads;
    }
}