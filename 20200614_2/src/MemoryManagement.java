import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//因为要释放作业时 这个作业必须已经是申请过的不然会抛出一个异常
class HomeWorkNotFindException extends Exception {

    public HomeWorkNotFindException(String message) {
        super(message);
    }
}

//还需要一个异常表示 内存放不下
class MemoryFullException extends Exception {
    public MemoryFullException(String message) {
        super(message);
    }
}


//作业类 有一个id和要申请或者的内存大小 和要执行什么操作
class HomeWork {

    public int id;
    public int need;
    public String doing;

    public HomeWork(int id, int need, String doing) {
        this.id = id;
        this.need = need;
        this.doing = doing;
    }
}

//区域类 表示内存的起始地址和大小和状态
class Area {

    public int homeWorkId;
    public int indexBig;
    public int areaSize;
    public boolean state;

    public Area(int homeWorkId, int indexBig, int areaSize, boolean state) {
        this.homeWorkId = homeWorkId;
        this.indexBig = indexBig;
        this.areaSize = areaSize;
        this.state = state;//true表示未分配 false表示已分配
    }

    @Override
    public String toString() {
        return indexBig + "k" + "  " + areaSize + "k" + "  " + (state ? "未分配" : "已分配");
    }
}

//主存储器空间的分配和回收的一个类
//需要一个链表去记录所有已分配和未分配区域
//需要一个加作业的方法
//需要一个释放作业的方法
//需要一个打印空闲区域的一个链表
public class MemoryManagement {

    private List<Area> list = new LinkedList<>();

    public MemoryManagement() {
        list.add(new Area(0, 0, 512, true));
    }

    //只需要把作业传进来 在这个类里会判断是要申请空间还是释放空间
    public void implementWork(HomeWork homeWork) throws HomeWorkNotFindException, MemoryFullException {

        if ("申请".equals(homeWork.doing)) {
            apply(homeWork);
            displayFreeArea();
        } else {
            if ("释放".equals(homeWork.doing)) {
                free(homeWork);
                displayFreeArea();
            }
        }

    }

    private void free(HomeWork homeWork) throws HomeWorkNotFindException {
        for (Area a: this.list
             ) {
            if (a.homeWorkId == homeWork.id) {
                a.state = true;
                for (int index = list.indexOf(a) - 1; index >= 0 && list.get(index).state; index--) {
                    Area area = list.get(index);
                    area.areaSize += a.areaSize;
                    list.remove(a);
                    a = area;
                }

                for (int index = list.indexOf(a) + 1; index < list.size() && list.get(index).state; index++) {
                    Area area = list.get(index);
                    a.areaSize += area.areaSize;
                    list.remove(area);
                }
                return;
            }
        }

        //抛出一个异常
        throw new HomeWorkNotFindException("未找到要释放的内存区域");
    }

    private void apply(HomeWork homeWork) throws MemoryFullException {
        //申请的时候遍历区域链表找到未分配的并且可以放的下作业的区域  如果没找到就放在最后面
        //但是此时肯可能会把未分配的一个区域变成俩个区域 一个表示已分配 一个表示未分配
        //最后要记得排序区域链表
        //区域状态true表示未分配 false表示已分配
        for (Area a : this.list
             ) {
            if (a.state && a.areaSize >= homeWork.need) {
                //找到那个我们需要的区域
                if (a.areaSize == homeWork.need) {
                    //空闲区域和需要的区域大小相等
                    a.homeWorkId = homeWork.id;
                    a.state = false;
                } else {
                    Area areaTrue = new Area(homeWork.id, a.indexBig, homeWork.need, false);
                    Area areaFalse = new Area(homeWork.id, a.indexBig + homeWork.need, a.areaSize - homeWork.need, true);
                    list.remove(a);
                    list.add(areaTrue);
                    list.add(areaFalse);
                }

                this.list.sort(new Comparator<Area>() {
                    @Override
                    public int compare(Area o1, Area o2) {
                        return o1.indexBig - o2.indexBig;
                    }
                });

                return;
            }
        }

        //如果最后一个空闲区域内存还是不够大
        throw new  MemoryFullException("内存放不下");

      /*  //此处说明链表里没找到合适位置就把他放到最后 此处有俩种情况 链表为空和链表不为空
        if (this.list.isEmpty()) {
            this.list.add(new Area(homeWork.id, 0, homeWork.need, false));
        } else {
            Area last = this.list.get(this.list.size() - 1);
            this.list.add(new Area(homeWork.id, last.indexBig + last.areaSize, homeWork.need, false));
        }
        this.list.sort(new Comparator<Area>() {
            @Override
            public int compare(Area o1, Area o2) {
                return o1.indexBig - o2.indexBig;
            }
        });*/
    }

    //打印空闲区域
    public void displayFreeArea() {

        System.out.println("======================");
        System.out.println("起址" + "  " + "长度" + "  " + "状态");
        for (Area a : this.list
             ) {
            if (a.state) {
                System.out.println(a.toString());
            }
        }
        System.out.println("======================");
    }
}
