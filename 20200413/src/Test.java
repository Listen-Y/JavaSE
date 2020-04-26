public class Test {

    public static int countNumbersWithUniqueDigits(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 10;
        }
        int result = 0;
        for(int numsIndex = 2; numsIndex <= n; numsIndex ++) {
            int count = 1;
            int num = 9;
            for(int i = 0; i < numsIndex; i ++) {
                if(i < 2) {
                    count = count * num;
                }else {
                    num = num - 1;
                    count = count * num;
                }
            }
            result += count;
        }

        return result + 10;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }
}
