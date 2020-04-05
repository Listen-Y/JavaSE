import java.awt.image.Kernel;

public class Test {
    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        if(pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(0);
        ListNode gol = newHead;
        ListNode find = pHead;
        while (find != null) {
            if(find.next !=null && find.next.data == find.data) {
                while (find.next != null && find.next.data == find.data) {
                    find = find.next;
                }
                find = find.next;
            }else {
                gol.next = find;
                find = find.next;
                gol = gol.next;
            }
        }
        gol.next = null;
        return newHead.next;
    }

    public static void display(ListNode phead) {
        ListNode find = phead;
        while (find !=  null) {
            System.out.print(find.data + " ");
            find = find.next;
        }
        System.out.println();
    }

    public static boolean chkPalindrome(ListNode A) {
        // write code here
        if(A == null) {
            return false;
        }
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode find = slow.next;
        ListNode finded = slow;
        while (find != null) {
            ListNode findNext = find.next;
            find.next = finded;
            finded = find;
            find = findNext;
        }
        find = A;
        while ( find != finded) {
            if(find.data != finded.data) {
                return false;
            }
            if(find.next == finded) {
                return true;
            }
            find = find.next;
            finded = finded.next;
        }
        return true;
    }

    public static boolean haveCircle(ListNode headA) {
        if(headA == null) {
            return false;
        }
        ListNode fast = headA;
        ListNode slow = headA;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void setCircle(ListNode head) {
        ListNode find = head;
        while (find.next != null) {
            find = find.next;
        }
        find.next = head.next.next.next;
    }

    public static ListNode findCommenListNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode findA = headA;
        ListNode findB = headB;
        while (findA != null) {
            lenA ++;
            findA = findA.next;
        }
        while (findB != null) {
            lenB ++;
            findB = findB.next;
        }
        int count = lenA - lenB;
        findA = headA;
        findB = headB;
        if(lenA - lenB < 0) {
            count = lenB - lenA;
            while (count != 0) {
                findB = findB.next;
                count --;
            }
        } else {
            while (count != 0) {
                findA = findA.next;
                count --;
            }
        }
        while (findA != null && findB != null) {
            findA = findA.next;
            findB = findB.next;
            if(findA == findB) {
                return findA;
            }
        }
        return null;
    }

    public static void set_Y(ListNode a, ListNode b) {
        a.next.next.next = b.next.next;
    }

    public static void main(String[] args) {
        MyLinkList linkList = new MyLinkList();
        linkList.addLast(1);
        linkList.addLast(1);
        linkList.addLast(1);
        linkList.addLast(1);
        linkList.addLast(1);
        linkList.addLast(1);
        linkList.addLast(1);
        linkList.addLast(1);
        linkList.addLast(1);
        //display(linkList.head);
        MyLinkList linkList1 = new MyLinkList();
        linkList1.addLast(2);
        linkList1.addLast(2);
        linkList1.addLast(2);
        linkList1.addLast(2);
        linkList1.addLast(2);
        linkList1.addLast(2);
        linkList1.addLast(2);
        set_Y(linkList.head, linkList1.head);
        display(linkList.head);
        display(linkList1.head);
        System.out.println(findCommenListNode(linkList.head, linkList1.head).data);
        //System.out.println(chkPalindrome(linkList.head));
        //setCircle(linkList.head);
        //display(linkList.head);
        //System.out.println(haveCircle(linkList.head));
        //linkList.addLast(70);
        //deleteDuplication(linkList.head);
        //ListNode ret = deleteDuplication(linkList.head);
        //display(ret);

    }
}
