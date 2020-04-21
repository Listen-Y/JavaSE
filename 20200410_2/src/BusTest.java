import java.util.ArrayList;

class Passanger {
    public String name;
    public String sex;
    public int age;

    public Passanger(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Passanger() {};
}

class Bus {
    private String busNum;//车牌号
    private String lineNum;//线路号
    private int gap;//发车间隔(以分钟作为单位)
    private String statrTime;//首发车时间
    private String endTime;//末班车时间
    private ArrayList<Passanger> passangers;//乘客链表
    private int currentPassCount;//当前的载客数

    //上车
    public void upBus(Passanger passanger) {
        if(passangers.size() < currentPassCount) {
             passangers.add(passanger);
            System.out.println(passanger.name + " 已上车");
            System.out.println("当前车上人数为:" + passangers.size());
        }else {
            System.out.println("车满了!" + passanger.name + "无法上车");
        }
    }

    //下车
    public void downBus(Passanger passanger) {
        if (passangers.remove(passanger)) {
            System.out.println(passanger.name + "已下车!");
            System.out.println("当前车上人数为:" + passangers.size());
            return;
        }
        System.out.println("车上无" + passanger.name);
    }

    //多人一起上车
    public void upsBus(Passanger[] passangers1) {
        if(passangers1 != null) {
            for (Passanger passanger : passangers1) {
                upBus(passanger);
            }
        }
    }

    //多人一起下车
    public void downsBus(Passanger[] passangers1) {
        if(passangers1 != null) {
            for (Passanger passanger: passangers1) {
                downBus(passanger);
            }
        }
    }

    public int getCurrentPassCount() {
        return currentPassCount;
    }

    public void setCurrentPassCount(int currentPassCount) {
        this.currentPassCount = currentPassCount;
    }

    public String getBusNum() {
        return busNum;
    }

    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public String getStatrTime() {
        return statrTime;
    }

    public void setStatrTime(String statrTime) {
        this.statrTime = statrTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Bus(String busNum, String lineNum, int gap, String statrTime, String endTime, int currentPassCount) {
        this.busNum = busNum;
        this.lineNum = lineNum;
        this.gap = gap;
        this.statrTime = statrTime;
        this.endTime = endTime;
        this.currentPassCount = currentPassCount;
        this.passangers = new ArrayList<>();
    }
}

public class BusTest {
    public static void main(String[] args) {
        Bus bus = new Bus("111", "222", 15, "333", "444", 5);
        Passanger passanger = new Passanger("YaYa", "man", 18);
        Passanger[] passangers = new Passanger[4];
        passangers[0] = new Passanger("BaBa", "man", 18);
        passangers[1] = new Passanger("CaCa", "man", 18);
        passangers[2] = new Passanger("DaDa", "man", 18);
        passangers[3] = new Passanger("EaEa", "man", 18);
        bus.upBus(passanger);
        bus.upsBus(passangers);
        bus.upsBus(passangers);
        bus.downBus(passanger);
        bus.downsBus(passangers);
        bus.downBus(passanger);
    }
}
