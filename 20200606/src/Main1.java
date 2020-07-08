import java.util.*;
public class Main1 {
    private static List<TwoNum> list = new ArrayList<>();

    static class TwoNum {
        public int x2;
        public int y2;
        public TwoNum(int x2, int y2) {
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            long beg = System.currentTimeMillis();
            String str = scan.nextLine();
            String[] strs = str.split(" ");
            int H = Integer.parseInt(strs[0]);
            int W = Integer.parseInt(strs[1]);
            //int H = scan.nextInt();
            //int W = scan.nextInt();
            int count = 0;
            for (int x = 0; x < H; x++) {
                for (int y = 0; y < W; y++) {
                    if (!isTwo(x, y)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            System.out.println(System.currentTimeMillis() - beg + "ms");
        }
    }
    private static boolean isTwo(int x1, int y1) {
        if (list.isEmpty()) {
            list.add(new TwoNum(x1, y1));
            return false;
        }
        for (TwoNum two : list) {
            if (Math.pow(x1 - two.x2, 2) + Math.pow(y1 - two.y2, 2) == 4.0) {
                return true;
            }
        }
        list.add(new TwoNum(x1, y1));
        return false;
    }
}