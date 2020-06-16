import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    static class Car {
        public int distance;
        public int speed;
        public float time;
        public Car(int distance, int speed) {
            this.distance = distance;
            this.speed = speed;
            this.time = (float) distance / speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new Car(target - position[i], speed[i]));
        }
        list.sort(new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                return o1.distance - o2.distance;
            }
        });
        int team = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean key = true;
            for (int j = 0; j < i; j++) {
                if(list.get(i).time <= list.get(j).time) {
                    key = false;
                    break;
                }
            }
            if (key) {
                team++;
            }
        }
        return team;
    }
}

public class Test {
    public static void main(String[] args) {
       /* int a = 4;
        int b= 3;
        System.out.println( (float) a/b);*/
       /*Solution solution = new Solution();
       int[] p = new int[] {6,8};
       int[] s = new int[] {3,2};
        System.out.println(solution.carFleet(10, p, s));*/
       MyHashMap myHashMap = new MyHashMap();
       int[] nums = new int[] {12,17,15,13,23,26,37};
        for (int x : nums
             ) {
            myHashMap.put(x, 10);
        }
        System.out.println(myHashMap.get(12));
        System.out.println(myHashMap.get(23));
        System.out.println(myHashMap.get(15));
        System.out.println(myHashMap.get(26));
        System.out.println(myHashMap.get(37));
        myHashMap.remove(12);
        myHashMap.remove(26);
        System.out.println("==================");
        System.out.println(myHashMap.get(12));
        System.out.println(myHashMap.get(23));
        System.out.println(myHashMap.get(15));
        System.out.println(myHashMap.get(26));
        System.out.println(myHashMap.get(37));
    }
}
