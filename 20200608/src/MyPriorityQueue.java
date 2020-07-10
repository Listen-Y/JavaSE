import com.sun.org.apache.regexp.internal.RE;

import javax.accessibility.AccessibleHyperlink;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    private List<Integer> list;

    public MyPriorityQueue() {
        this.list = new LinkedList<>();
    }
    public void add(int val) {
        if (list.isEmpty()) {
            list.add(val);
            return;
        }
        list.add(val);
        shitfUp(list.size() - 1);
    }

    private void shitfUp(int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (list.get(parent) > list.get(child)) {
                int tmp = list.get(parent);
                list.set(parent, list.get(child));
                list.set(child, tmp);
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public Integer poll() {
        if (list.isEmpty()) {
            return null;
        }
        int ret = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        shiftDowm(0);
        return ret;
    }

    private void shiftDowm(int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < list.size()) {
            if (child + 1 < list.size() && list.get(child + 1) < list.get(child)) {
                child++;
            }
            if (list.get(parent) > list.get(child)) {
                int tmp = list.get(parent);
                list.set(parent, list.get(child));
                list.set(child, tmp);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
