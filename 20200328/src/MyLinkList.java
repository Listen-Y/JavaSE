public class MyLinkList {
    public ListNode head;
    public MyLinkList() {
        this.head = null;
    }
    public void addLast(int data) {
        ListNode elem = new ListNode(data);
        if(this.head == null) {
            this.head = elem;
            return;
        }
        ListNode find = this.head;
        while (find.next != null) {
            find = find.next;
        }
        find.next = elem;
    }

    public ListNode deleteDuplication(ListNode pHead) {
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
            if(find.next.data == find.data) {
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
        return newHead.next;
    }

    public void display(ListNode phead) {
        ListNode find = phead;
        while (find !=  null) {
            System.out.print(find.data + " ");
            find = find.next;
        }
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp =  newHead;
        //1、当两个单链表都不为空的时候
        if(headA == null && headB == null) {
            return null;
        }
        if(headA == null) {
            return headB;
        }
        if(headB == null) {
            return headA;
        }
        //2、第一步完成后   其中一个单链表不为空  一个为空
        while (headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headB == null) {
            tmp.next = headA;
        }
        if(headA == null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

}
