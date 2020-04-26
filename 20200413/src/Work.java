import java.util.*;

public class Work {

    public static int[] arrayRankTransform2(int[] arr) {
        int[] arrClone = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrClone);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for(int i = 0; i < arrClone.length; i ++) {
            if( ! map.containsKey(arrClone[i])) {
                map.put(arrClone[i], count);
                count ++;
            }
        }
        for(int i = 0; i < arr.length; i ++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for( int i = 0; i < arr.length; i ++) {
            int count = 1;
            for( int j = 0; j < arr.length; j ++) {
                if(arr[i] > arr[j] && ! list.contains(arr[j])) {
                    list.add(arr[j]);
                    count ++;
                }
            }
            result[i] = count;
            list.clear();
        }
        return result;
    }

    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int value : nums) {
            int num = value;
            int count = 0;
            while (num != 0) {
                num /= 10;
                count++;
            }
            if (count % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*String s = "aaaaaaa";
        System.out.println(s.length());*/
        int[] arr = new int[] {-4444, -222343234, -432434234,-345432432, -324324324, -324324234, 32432432, -3423423};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
}
