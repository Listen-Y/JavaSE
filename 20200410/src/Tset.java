import java.util.ArrayList;
import java.util.Random;

/**
 * Random ArrayList
 */

public class Tset {

    public static ArrayList<Integer> getFiveInTwentyTwo() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (arrayList.size() < 5) {
            Random random = new Random();
            int temp = random.nextInt(22) + 1;
            if( ! arrayList.contains(temp)) {
                arrayList.add(temp);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = getFiveInTwentyTwo();
        System.out.println(arrayList);
    }
}
