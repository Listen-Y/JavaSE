public class MemoryTest {
    public static void main(String[] args) {

        MemoryManagement memoryManagement = new MemoryManagement();

        //创建作业
        HomeWork[] homeWorks = new HomeWork[8];
        homeWorks[0] = new HomeWork(1, 300, "申请");
        homeWorks[1] = new HomeWork(2, 100, "申请");
        homeWorks[2] = new HomeWork(1, 300, "释放");
        homeWorks[3] = new HomeWork(3, 150, "申请");
        homeWorks[4] = new HomeWork(4, 30, "申请");
        homeWorks[5] = new HomeWork(5, 40, "申请");
        homeWorks[6] = new HomeWork(6, 60, "申请");
        homeWorks[7] = new HomeWork(4, 30, "释放");
       // homeWorks[8] = new HomeWork(7, 600, "申请");
        //
        System.out.println("初始空闲说明表");
        memoryManagement.displayFreeArea();

        //执行作业
        for (HomeWork h : homeWorks
             ) {

                System.out.println();
                System.out.println();
                System.out.println("执行作业" + h.id + "任务是" + h.doing + h.need + "k");
            try {
                memoryManagement.implementWork(h);
            } catch (HomeWorkNotFindException | MemoryFullException e) {
                e.printStackTrace();
            }

        }
    }
}
