import java.util.*;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret = ret ^ x;
        }
        return ret;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    //
    //要求返回这个链表的 深拷贝。
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for ( Node node = head; node != null; node = node.next) {
            map.put(node, new Node(node.val));
        }
        for (Node node = head; node != null; node = node.next) {
            //tmp是新结点，设置新节点的next和random
            //tmp的next和random是旧结点的next和randomd对应的新节点
            Node tmp = map.get(node);
            tmp.next = map.get(node.next);
            tmp.random = map.get(node.random);
        }
        return map.get(head);
    }
    //给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
    //
    //J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/jewels-and-stones
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int numJewelsInStones(String J, String S) {
        //将j中的字符放到set中，遍历s看set是否有s里的字符，如果有count++
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    //给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序
    public List<String> topKFrequent(String[] words, int k) {
        //遍历words建立map
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        //将map里的key放到一个链表里
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int countO1 = map.get(o1);
                int countO2 = map.get(o2);
                if (countO1 == countO2) {
                    return o1.compareTo(o2);
                }
                return countO2 - countO1;
            }
        });
        return list.subList(0, k);
    }

    public List<String> myTopKFrequent(String[] words, int k) {
        //用map统计字符串出现次数，将字符串去重放入链表，对链表进行排序，自定义排序规则
        Map<String, Integer> map = new HashMap<>();
        for (String s : words
             ) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<String>() {

                      @Override
                      public int compare(String o1, String o2) {
                          //自定义比较规则，根据字符串和map找到他出现的次数
                          int count1 = map.get(o1);
                          int count2 = map.get(o2);
                          //如果次数相等就按字符串大小比较
                          if(count1 == count2) {
                              return o1.compareTo(o2);
                          }
                          return count2 - count1;
                      }
                  }
        );
        return list.subList(0, k);
    }
}

public class MapSetOJ {
}
