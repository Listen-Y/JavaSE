/**
 *
 *
 * 链表练习题
 */

package listen.Y;

public class Test {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode findA = l1;
        ListNode findB = l2;
        while (findA != null && findB != null) {
            findA.date = findA.date + findB.date;
            if(jinwei != 0) {
                findA.date = findA.date + jinwei;
                jinwei --;
            }
            if(findA.date >= 10) {
                findA.date = findA.date % 10;
                jinwei ++;
            }
            findA = findA.next;
            findB = findB.next;
        }
        if(findA == null && findB == null) {
            if(jinwei != 0) {
                ListNode  add= new ListNode(jinwei);
                ListNode find = l1;
                while (find.next != null) {
                    find = find.next;
                }
                find.next = add;
                return l1;
            }else {
                return l1;
            }
        }
        if(findA != null) {
            while (findA != null && jinwei != 0) {
                findA.date = findA.date + jinwei;
                jinwei --;
                if (findA.date >= 10) {
                    findA.date = findA.date % 10;
                    jinwei ++;
                }else  {
                    break;
                }
                findA = findA.next;
            }
            if(jinwei != 0) {
                ListNode add = new ListNode(jinwei);
                ListNode finded = l1;
                while (finded.next != null) {
                    finded = finded.next;
                }
                finded.next = add;
            }
            return l1;
        } else {
            ListNode find = l1;
            while (find.next != null) {
                find = find.next;
            }
            find.next = findB;
            find = find.next;
            while (find != null && jinwei != 0) {
                find.date = find.date + jinwei;
                jinwei --;
                if (find.date >= 10) {
                    find.date = find.date % 10;
                    jinwei ++;
                }else  {
                    break;
                }
                find = find.next;
            }
            if(jinwei != 0) {
                ListNode add = new ListNode(jinwei);
                ListNode finded = l1;
                while (finded.next != null) {
                    finded = finded.next;
                }
                finded.next = add;
            }
            return l1;
        }
    }

    public static void display(ListNode node) {
        while (node != null) {
            System.out.print(node.date + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MyLinkList linkList = new MyLinkList();
        linkList.addLast(1);
        //linkList.addLast(4);
        //linkList.addLast(3);
        MyLinkList linkList1 = new MyLinkList();
        linkList1.addLast(9);
        linkList1.addLast(9);
        //linkList1.addLast(4);
        //ListNode ret = addTwoNumbers(linkList.head, linkList1.head);
        //display(ret);

    }
}
