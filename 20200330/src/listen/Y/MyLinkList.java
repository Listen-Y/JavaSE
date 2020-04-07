package listen.Y;

public class MyLinkList {
     public ListNode head;

     public MyLinkList() {
         this.head = null;
     }

     public void addLast(int date) {
         ListNode elem = new ListNode(date);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
             return l1;
         } else {
             ListNode find = l1;
             while (find.next != null) {
                 find = find.next;
             }
             find.next = findB;
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
             return l1;
         }
    }

    public  ListNode reaturnHaveCircleNode(ListNode headA) {
        if(headA == null) {
            return null;
        }
        ListNode fast = headA;
        ListNode slow = headA;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                slow = this.head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}
