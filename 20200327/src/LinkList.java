import com.sun.xml.internal.ws.api.WSDLLocator;

public class LinkList {
    private Node head;
    public LinkList() {
        this.head = null;
    }
    public void addLast(int date) {
        Node elem = new Node(date);
        if(this.head == null) {
            this.head = elem;
            return;
        }
        Node find = this.head;
        while (find.next != null) {
            find = find.next;
        }
        elem.next = find.next;
        find.next = elem;
    }

    public Node reserveLinkList() {
        if(this.head == null) {
            return null;
        }
        if(this.head.next == null) {
            return this.head;
        }
        Node find = this.head.next;
        Node finded = this.head;
        while (find != null) {
            Node findNext = find.next;
            find.next = finded;
            finded = find;
            find = findNext;
        }
        Node newHead = finded;
        this.head.next = null;
        return newHead;

    }
    public void display() {
        Node find = this.head;
        while (find != null) {
            System.out.print(find.date + " ");
            find = find.next;
        }
        System.out.println();
    }

    public void display2(Node head) {
        Node find = head;
        while (find != null) {
            System.out.print(find.date + " ");
            find = find.next;
        }
        System.out.println();
    }

    public Node returnMidNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node returnNode_K(int k) {
        if(k < 1) {
            System.out.println("ERROE");
            return null;
        }
        int count = 0;
        Node fast = this.head;
        while (count < k - 1) {
            if(fast.next == null) {
                System.out.println("ERROR");
                return null;
            }
            fast = fast.next;
            count ++;
        }
        Node slow = this.head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node mergeTwoLists(Node head1, Node head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        Node a = head1;
        Node b = head2;
        Node aNext = a.next;
        Node bNext = b.next;
        return null;
    }

    public Node partition( int x) {
        // write code here
        Node aLow = null;
        Node aHigh = null;
        Node bLow = null;
        Node bHigh = null;
        if(this.head == null) {
            return null;
        }
        Node head = this.head;
        while (head != null) {
            if(head.date < x) {
                if(aLow == null) {
                    aLow = head;
                    aHigh = aLow;
                    head = head.next;
                }else {
                    aHigh.next = head;
                    aHigh = aHigh.next;
                    head = head.next;
                }
            }else {
                if(bLow == null) {
                    bLow = head;
                    bHigh = bLow;
                    head = head.next;
                }else {
                    bHigh.next = head;
                    bHigh = bHigh.next;
                    head = head.next;
                }
            }
        }
        if(aLow == null) {
            bHigh.next = null;
            return bLow;
        }
        if(bLow == null) {
            aHigh.next = null;
            return aLow;
        }
        aHigh.next = bLow;
        Node newHead = aLow;
        bHigh.next = null;
        return newHead;
    }

}
