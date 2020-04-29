import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class MyLinkedList {

    /** Initialize your data structure here. */
    static class Node {
        public int val;
        public Node next;
        public Node (int val) {
            this.val = val;
        }
    }
    private Node head;
    private int size;
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > size) {
            return -1;
        }
        Node find = this.head;
        for(int i = 0; i < index - 1; i ++) {
            find = find.next;
        }
        return find.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node find = new Node(val);
        if(this.head == null) {
            this.head = find;
            size ++;
            return;
        }
        find.next = this.head;
        this.head = find;
        size ++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node find = new Node(val);
        if(this.head == null) {
            this.head = find;
            size ++;
            return;
        }
        Node gol = this.head;
        while(gol.next != null) {
            gol = gol.next;
        }
        gol.next = find;
        size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index <= 1) {
            addAtHead(val);
            return;
        }
        if(index == size) {
            addAtTail(val);
            return;
        }
        if(index > size) {
            return;
        }
        Node find = this.head;
        for(int i = 0; i < index - 1 - 1; i ++) {
            find = find.next;
        }
        Node gol = new Node(val);
        gol.next = find.next;
        find.next = gol;
        size ++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 1 || index > size) {
            return;
        }
        if(index == 1) {
            this.head = this.head.next;
            size --;
            return;
        }
        Node find = this.head;
        for(int i = 0; i < index -1-1; i ++) {
            find = find.next;
        }
        find.next = find.next.next;
        size --;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class WorkTest {
//{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}}
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid[0].length;
        int m = grid.length;
        int length = n * m;
        int[] nums = new int[length];
        for(int i = 0; i < m; i ++) {
            for( int j = i * n; j < i * n +n; j ++) {
                int index = j + k;
                index %= length;
                nums[index] = grid[i][j - i * n];
            }
        }
        List<List<Integer>> listList = new ArrayList<>();
        for(int i = 0; i < length; ) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            i ++;
            while(true) {
                if(i % n == 0) {
                    listList.add(list);
                    break;
                }
                list.add(nums[i]);
                i ++;
            }
        }
        return listList;
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int i:A){
            sum+=i;
        }
        if(sum%3!=0) return false;
        sum/=3;
        int count=0,temp=0;
        for(int i:A){
            temp+=i;
            if(temp==sum){
                count++;
                temp=0;
            }
        }
        return count>=3;
    }

    public static int findJudge(int N, int[][] trust) {
        List<Integer> judeg = new ArrayList<>();
        for(int i = 1; i <= N; i ++) {
            judeg.add(i);
        }
        for (int[] ints : trust) {
            judeg.remove((Integer) ints[0]);
        }
        if(judeg.size() != 1) {
            return -1;
        }
        int judegNum = judeg.get(0);
        int count = 0;
        for (int[] ints : trust) {
            if (ints[1] == judegNum) {
                count++;
            }
        }
        if(count == N - 1) {
            return judegNum;
        }
        return -1;
    }


// Employee info
static class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};


        public static int getImportance(List<Employee> employees, int id) {
            Employee findEmployee = new Employee();
            for (Employee employee : employees) {
                if (employee.id == id) {
                    findEmployee = employee;
                    break;
                }
            }
            int sumImportance = findEmployee.importance;
            for(int i = 0; i < findEmployee.subordinates.size(); i ++) {
                int findId = findEmployee.subordinates.get(i);
                sumImportance += getImportance(employees, findId);
            }
            return sumImportance;
        }

    public static void main(String[] args) {
        /*int[][] grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        System.out.println(shiftGrid(grid, 1));*/
        /*int[] arr = new int[] {1,-1,1,-1,1,-1,1,1,1,1};
        System.out.println(canThreePartsEqualSum(arr));*/
        int[][] arr = new int[][] {{1,2}};
        System.out.println(findJudge(2,arr));
    }
}
