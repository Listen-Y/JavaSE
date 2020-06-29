/**
 * 优化银行家算法,实现资源再次申请
 */

//系统资源的数据结构
class Resources {
    public String name;
    public int num;

    public Resources(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "资源"+ name  + "有" + num;
    }
}
//进程的数据结构
class PCB {
    public String name;
    public Resources[] max;//最大需求资源Max
    public Resources[] allocation;//已分配资源Allocation
    public Resources[] need;//需求资源Need
    public boolean finish = false;//表示进程是否获得足够资源

    public PCB(String name, Resources[] max, Resources[] allocation) {
        this.name = name;
        this.max = max;
        this.allocation = allocation;
        this.need = new Resources[max.length];
        for (int i = 0; i < need.length; i++) {
            this.need[i] = new Resources(max[i].name, max[i].num - allocation[i].num);
        }
    }

    @Override
    public String toString() {
        return this.name +(this.finish ? "进程已得到足够资源" : "需要等待");
    }
}

public class BetterBankerAlgorithm {
    private Resources[] work;//当前可以资源
    private PCB[] pcbs;//所有进程

    public BetterBankerAlgorithm(Resources[] Available, PCB[] pcbs) {
        this.work = Available;//一开始可用资源与系统总资源是相同的
        this.pcbs = pcbs;
        //计算剩余可用资源
        actualWork();
    }

    private void actualWork() {
        for (int i = 0; i < this.work.length; i++) {
            //初始系统总资源减去已分配的资源就是当前可以利用的资源
            this.work[i].num = this.work[i].num - pcbsAllRes(i);
        }
    }
    //计算所有进程已分配的第i个资源总数
    private int pcbsAllRes(int index) {
        int sum = 0;
        for ( PCB p : pcbs
        ) {
            sum += p.allocation[index].num;
        }
        return sum;
    }

    //判断是否为安全状态
    private boolean ifSafe() {
        for (PCB p : pcbs
        ) {
            if (! p.finish) {
                return false;
            }
        }
        return true;
    }

    //进行资源分配
    public void resAllocation() {
        //对进程进行循环资源分配,当所有进程都需要等待或者所有进程都为安全状态退出循环
        for (int i = 0; !ifSafe() && !ifAllNeedWait(); i++) {
            //实现循环
            if (i == this.pcbs.length) {
                i = 0;
            }
            //判断当前这个进程是否已经获得过足够资源
            if (pcbs[i].finish) {
                continue;
            }
            //判断当前这个进程是否需要等待
            if (! needWait(pcbs[i])) {
                //进行资源分配
                mainOperation(pcbs[i]);
                System.out.println(pcbs[i]);
                System.out.println();
                displayWorks();
            }
        }
        System.out.println();
        if (ifSafe()) {
            System.out.println("系统处于安全状态");
        } else {
            System.out.println("系统处于不安全状态");
        }
    }

    private void displayWorks() {
        System.out.println("此时系统可用资源为:");
        System.out.println("====================");
        for (Resources r : this.work
        ) {
            System.out.println(r);
        }
        System.out.println("====================");
    }

    private boolean ifAllNeedWait() {
        for (PCB p : this.pcbs
        ) {
            //如果该进程已经得到过足够资源就不进行判断
            if (!p.finish) {
                //如果该进程不需要等待就直接返回false
                if (!needWait(p)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void mainOperation(PCB pcb) {
        //运行到这说明该进程可以得到足够的资源,那么直接将该进程已分配的资源放回到系统中
        //并将finish改为true
        for (int i = 0; i < this.work.length; i++) {
            this.work[i].num += pcb.allocation[i].num;
            pcb.finish = true;
        }
    }

    private boolean needWait(PCB pcb) {
        //挨个判断此时pcb这个进程所需要的每个资源,如果need大于系统当前可分配资源,就说明需要等待
        for (int i = 0; i < this.work.length; i++) {
            if (this.work[i].num < pcb.need[i].num) {
                return true;
            }
        }
        return false;
    }
}

