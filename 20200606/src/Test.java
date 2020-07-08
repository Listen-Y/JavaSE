import java.util.Scanner;
//贪心算法
public class Test {
    private static int[] moneyKind = new int[] {1, 5, 10, 20, 50, 100};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int money = scanner.nextInt();
            greedyFunc(money, moneyKind.length - 1);
        }
    }

    private static void greedyFunc(int money, int index) {
        //防止下标越界
        if (index < 0) {
            return;
        }
        //如果此时需要的钱是0就直接返回
        if (money == 0) {
            return;
        }
        //如果此时需要的钱比此时的面值小,就往下一个面值递归
        if (money < moneyKind[index]) {
            greedyFunc(money, index - 1);
        } else {
            int num = money / moneyKind[index];
            System.out.println("需要:" + moneyKind[index] + "元" + num + "张");
            money = money - num * moneyKind[index];
            greedyFunc(money, index - 1);
        }
    }
}
