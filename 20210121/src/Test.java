/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-22
 * Time: 18:27
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(fun(3));
    }

    /**
     * 学号 姓名 班级 a
     * 学号 科目 成绩 b
     * 数学成绩大于90分的人数, 大于5个的班级
     * select a.班级  from b, a where a.id = b.id and b.成绩 > 90 and b.科目='数学' and count(a.学号) > 5 group by a.班级;
     */

    public static int fun(int n) {
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += funHelper(i);
        }
        return ret;
    }

    private static int funHelper(int i) {
        if (i % 2 == 1) {
            return i;
        }
        int max = 1;
        for (int j = 1; j < i; j+= 2) {
            if (i % j == 0 && j > max) {
                max = j;
            }
        }
        return max;
    }



}
