/**
 * Map Collection
 */


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestCollection {

    public static void main3(String[] args) {
        //内置类型装箱
        Integer i = Integer.valueOf(10);
        Integer i1 = new Integer(10);
        //拆箱
        int i2 = 10;
    }

    public static void main(String[] args) {

        //
        Map<String, String> map = new HashMap<>();
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        map.put("Zero", "000");
        map.put("One", "111");
        map.put("Two", "222");
        System.out.println(map.containsKey("Zero"));
        System.out.println(map.containsValue("222"));
        System.out.println(map.get("Two"));
        System.out.println(map.size());
        map.put("Three", "333");
        System.out.println(map.size());
        System.out.println(map.get("Fore"));
        System.out.println(map.getOrDefault("Fore", "444"));
        for (Map.Entry<String , String> entry : map.entrySet()
             ) {
            System.out.println(entry);
        }
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.remove("Zero");
        for (Map.Entry<String , String> entry : map.entrySet()
        ) {
            System.out.println(entry);
        }
        System.out.println(map.remove("One", "111"));
        for (Map.Entry<String , String> entry : map.entrySet()
        ) {
            System.out.println(entry);
        }
        map.replace("Two", "二二二");
        map.replace("Three", "333", "三三三");
        for (Map.Entry<String , String> entry : map.entrySet()
        ) {
            System.out.println(entry);
        }
        map.replace("Three", "222", "333");
        for (Map.Entry<String , String> entry : map.entrySet()
        ) {
            System.out.println(entry);
        }
    }

    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("aaa");
        System.out.println(collection.contains("aaa"));
        System.out.println(collection.equals("aaa"));
        System.out.println(collection.isEmpty());
        collection.remove("aaa");
        System.out.println(collection.isEmpty());
    }

}
