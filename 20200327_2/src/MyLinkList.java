public class MyLinkList {
    private ListNode phead;
    public MyLinkList() {
        this.phead = null;
    }

    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.phead == null) {
            //第一次插入节点
            this.phead = node;
            return;
        }
        node.next = this.phead;
        this.phead = node;
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.phead == null) {
            this.phead = node;
            return;
        }
        ListNode cur = this.phead;
        while (cur.next!= null) {
            cur = cur.next;
        }
        //cur指向的节点就是尾巴
        cur.next = node;
    }

    public void display(){
        ListNode cur = this.phead;
        while (cur != null) {
            System.out.print(cur.date+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode reserveLinkList() {
        if(this.phead == null) {
            return null;
        }
        if(this.phead.next == null) {
            return this.phead;
        }
        ListNode find = this.phead.next;
        this.phead.next = null;
        while (find != null) {
            ListNode findNext = find.next;
            addFirst(find.date);
            find = findNext;
        }
        return this.phead;
    }

    public void display2(ListNode head) {
        ListNode find = head;
        while (find != null) {
            System.out.print(find.date + " ");
            find = find.next;
        }
        System.out.println();
    }


}
