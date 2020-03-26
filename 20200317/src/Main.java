import java.util.Arrays;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] worksDiPi = new int[2*M];
        for(int i = 0; i < worksDiPi.length; i ++) {
            worksDiPi[i] = scan.nextInt();
        }
        int[] mansAi = new int[N];
        for(int i = 0; i < N; i ++) {
            mansAi[i] = scan.nextInt();
        }
        functionBestWorks(mansAi, worksDiPi);
    }
    public static void functionBestWorks(int[] mansAi, int[] worksDiPi) {
        for(int i = 0; i < mansAi.length; i ++) {
            int bestWork = findBestWork(mansAi[i],worksDiPi);
            System.out.println(bestWork);
        }
    }
    public static int findBestWork(int Ai, int[] worksDiPi) {
        int[] bestWorks = new int[worksDiPi.length / 2 + 1];
        Arrays.fill(bestWorks, 0);
        for(int i = 0, j = 0; i < worksDiPi.length; i += 2) {
            if(worksDiPi[i] <= Ai) {
                bestWorks[j] = worksDiPi[i + 1];
                j ++;
            }
        }
        Arrays.sort(bestWorks);
        return bestWorks[bestWorks.length - 1];
    }
}