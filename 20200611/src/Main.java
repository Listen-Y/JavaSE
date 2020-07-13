import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            List<Integer> list = new ArrayList<>();
            for (Character c : map.keySet()
                 ) {
                list.add(c - '0');
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i : list
                 ) {
                System.out.println(i + ":" + map.get(String.valueOf(i).charAt(0)));
            }
        }
    }
}

class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        Arrays.fill(B, 1);
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
}
