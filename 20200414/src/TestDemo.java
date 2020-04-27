import java.util.*;


class ListNode {
     int val;
     ListNode next;
   ListNode(int x) { val = x; }
 }

public class TestDemo {
    //给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
    //你可以假设除了数字 0 之外，这两个数字都不会以零开头。
    //进阶：
    //如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> listL1 = new ArrayList<>();
        List<Integer> listL2 = new ArrayList<>();
        while(l1 != null) {
            listL1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            listL2.add(l2.val);
            l2 = l2.next;
        }
        int length = listL1.size() - listL2.size();
        if(length > 0) {
            while(length != 0) {
                listL2.add(0, 0);
                length -- ;
            }
        }else {
            while(length != 0) {
                listL1.add(0, 0);
                length ++;
            }
        }
        for(int i = listL1.size() - 1; i > 0 ; i --) {
            int sum = listL1.get(i) + listL2.get(i);
            if(sum >= 10) {
                sum %= 10;
                listL1.set(i - 1, listL1.get(i - 1) + 1);
            }
            listL1.set(i, sum);

        }
        int sum = listL1.get(0) + listL2.get(0);
        if(sum >= 10) {
            sum %= 10;
            listL1.set(0, sum);
            listL1.add(0, 1);
        }else {
            listL1.set(0, sum);
        }
        ListNode newHead = new ListNode(0);
        ListNode find = newHead;
        for(int i = 0; i < listL1.size(); i ++) {
            ListNode temp = new ListNode(listL1.get(i));
            find.next = temp;
            find = temp;
        }
        return newHead.next;
    }
    //给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
    //
    //水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
    //
    //反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
    //
    //示例 1:
    //
    //输入: [[1,1,0],[1,0,1],[0,0,0]]
    //输出: [[1,0,0],[0,1,0],[1,1,1]]
    //解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
    //     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
    public static int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i ++) {
            int low = 0;
            int high = A[i].length - 1;
            while(low < high) {
                int temp = A[i][high];
                A[i][high] = A[i][low];
                A[i][low] = temp;
                low ++;
                high --;
            }
        }
        for(int i = 0; i < A.length; i ++) {
            for(int j = 0; j < A[i].length; j ++) {
                if(A[i][j] == 0) {
                    A[i][j] = 1;
                }else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {

    }
}
