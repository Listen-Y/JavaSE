import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {

    public static void main1(String[] args) {
        //ConcurrentHashMap使用volatile来保证读操作的不加锁
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "a");
        String a = map.get("a");
    }

    public static void main(String[] args) {
    }
}
