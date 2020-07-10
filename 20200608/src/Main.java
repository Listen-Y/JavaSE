import java.util.*;
public class Main{
    public static void main1(String[] args){
        Scanner sc=new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int evenICount = (n / 4) * 2 + (Math.min(n % 4, 2));//分了奇数行，偶数行
        int oddICount = ((n - 2) / 4) * 2 + (Math.min((n - 2) % 4, 2));
        int ans = m / 4 * (evenICount + oddICount) * 2;//通过其确定的行数来确定
        if(m % 4 > 0) ans += evenICount;//处理起来其实就是余数为123三种情况，这样写也是可以的
        if(m % 4 > 1) ans += evenICount;
        if(m % 4 > 2) ans += oddICount;
        /* if(m % 4 == 1) ans += evenICount;
        if(m % 4 ==2) ans += evenICount*2;
        if(m % 4 ==3) ans += oddICount+evenICount*2;**/
        System.out.println(ans);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
       /* queue.add(3);
        queue.add(9);
        queue.add(6);
        queue.add(1);
        queue.add(4);
        for (int x : queue
             ) {
            System.out.println(x);
        }*/
        System.out.println(-2 / 2);
    }
}