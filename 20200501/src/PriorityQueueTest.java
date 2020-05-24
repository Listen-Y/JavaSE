import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//373. 查找和最小的K对数字
//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
//
//定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
//
//找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
class Solution {
    static class sumNums {
        public int num1;
        public int num2;
        public int sum;
        public sumNums(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k <= 0) {
            return result;
        }
        PriorityQueue<sumNums> pQ = new PriorityQueue<>((o1, o2) -> o1.sum - o2.sum);
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                pQ.offer(new sumNums(num1, num2));
            }
        }
        for(int i = k; i > 0; i --) {
            sumNums ret = pQ.poll();
            if(ret == null) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(ret.num1);
            list.add(ret.num2);
            result.add(list);
        }
        return result;
    }
}
//有一堆石头，每块石头的重量都是正整数。
//
//每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
//如果 x == y，那么两块石头都会被完全粉碎；
//如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/last-stone-weight
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution1 {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i : stones) {
            pQ.offer(i);
        }
        while(pQ.size() > 1) {
            int x = pQ.poll();
            int y = pQ.poll();
            if(x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            if(x == y) {
                continue;
            }else {
                y -= x;
                pQ.offer(y);
            }
        }
        if(pQ.size() == 0) {
            return 0;
        }
        return pQ.poll();
    }
}

public class PriorityQueueTest {

    public static void main(String[] args) {
        //lambda表达式，java8之后才有的新东西，相当于一个匿名方法
        //代码省略太多以至于不好理解，但是实现方便
        //1
        PriorityQueue<Integer> pQ = new PriorityQueue<>((Integer o1, Integer o2) -> {
            return o2 - o1;
        });
        //2
        PriorityQueue<Integer> pQ1 = new PriorityQueue<>((Integer o1, Integer o2) -> o2 - o1);
        //3
        PriorityQueue<Integer> pQ2 = new PriorityQueue<>(( o1,  o2) -> o2 - o1);
        pQ2.offer(4);
        pQ2.offer(0);
        pQ2.offer(3);
        pQ2.offer(8);
        pQ2.offer(5);
        //库的优先队列是小堆，我们将其变为大堆
        while (!pQ2.isEmpty()) {
            System.out.print(pQ2.poll() + " ");
        }
    }

    public static void main2(String[] args) {
        //定义匿名内部类实现Comparator接口，并重写compare方法
        //匿名类就是不知道其名字的类，内部类就是定义在类中或者定义在方法中的类
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pQ.offer(4);
        pQ.offer(0);
        pQ.offer(3);
        pQ.offer(8);
        pQ.offer(5);
        //库的优先队列是小堆，我们将其变为大堆
        while (!pQ.isEmpty()) {
            System.out.print(pQ.poll() + " ");
        }
    }

    static class com implements Comparator<Integer> {
        //定义一个静态内部类，继承Comparator接口，并重写他的compare方法
        //return o2-o1 就可以
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public static void main1(String[] args) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new com());
        pQ.offer(4);
        pQ.offer(0);
        pQ.offer(3);
        pQ.offer(8);
        pQ.offer(5);
        //库的优先队列是小堆，我们将其变为大堆
        while (!pQ.isEmpty()) {
            System.out.print(pQ.poll() + " ");
        }
    }
}
