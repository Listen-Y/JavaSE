import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    public static boolean findnum(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] < key) {
                low = mid + 1;
            }else if(nums[mid] > key) {
                high = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        //System.out.println(findMin(nums));
        int[] ints = new int[] {1,2,3,4,5,6,7,8,9};
        System.out.println(findnum(ints, 6));
    }

    public static void main1(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("fff");
        list.add("eee");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
    }
}
