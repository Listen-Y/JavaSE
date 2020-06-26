class PCB {
    public String pcbName;
    public PCB next;
    public int time;
    public int priority;
    public char state = 'R';

    public PCB(String pcbName, int time, int priority) {
        this.pcbName = pcbName;
        this.time = time;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "进程名:" + pcbName +  "  要求运行时间:" + time + "  优先级数:" + priority
                 + "  状态:" + state;
    }
}

public class ProcessScheduling {
    private PCB head;
    //pcb对象插入操作
    public void addPCB(PCB node) {
        //如果所需运行时间为0,状态改为E 退出进程队列
        if (node.time == 0) {
            node.state = 'E';
            System.out.println(node.pcbName + "退出进程队列");
            System.out.println(node);
            System.out.println();
            return;
        }
        //若头结点为空
        if (this.head == null) {
            this.head = node;
            return;
        }
        //进行边插边按优先级进行排序

        //如果优先级比头结点大
        if (node.priority > this.head.priority) {
            node.next = this.head;
            this.head = node;
            return;
        }
        //如果和头结点优先级相同,按先来先服务原则
        if (node.priority == this.head.priority) {
            node.next = this.head.next;
            this.head.next = node;
            return;
        }
        //在node的优先级在中间插入
        PCB cur = this.head.next;
        PCB parent = this.head;
        while (cur != null) {
            if (node.priority > cur.priority) {
                //进行插入
                node.next = parent.next;
                parent.next = node;
                return;
            } else if (node.priority == cur.priority) {
                //优先级相同,按先来先服务原则
                parent = cur;
                node.next = parent.next;
                parent.next = node;
                return;
            }
            parent = cur;
            cur = cur.next;
        }
        //此时还未结束说明优先级最下就直接插到尾
        parent.next = node;
        node.next = null;
    }

    //进程运行方法
    public void runPCB() {
        while (this.head != null) {
            //运行优先级最高的第一个进程
            PCB cur = this.head;
            this.head = this.head.next;
            System.out.println();
            System.out.println("开始执行" + cur.pcbName + "进程");
            System.out.println(cur);
            //cur的运行优先级-1 运行时间-1
            cur.priority -= 1;
            cur.time -= 1;
            System.out.println(cur.pcbName + "进程执行完毕");
            System.out.println();
            //将cur再插入进程队列
            addPCB(cur);
            //运行一次结束后遍历显示此时进程队列所有信息
            if (this.head == null) {
                System.out.println("所有进程执行完毕");
                return;
            }
            System.out.println("此时进程队列的所有进程信息:");
            System.out.println("=================");
            display();
            System.out.println("=================");
        }
    }

    public void display() {
        for (PCB pcb = this.head; pcb != null; pcb = pcb.next) {
            System.out.println(pcb);
        }
    }
}
