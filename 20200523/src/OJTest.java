import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度
class Solution {
    public int removeDuplicates(int[] nums) {
        int ret = 0;
        if (nums == null) {
            return ret;
        }
        int length = nums.length;
        for (int i = 0; i < length; ) {
            ret++;
            i++;
            if (i < length && nums[i] == nums[i - 1]) {
                ret++;
                i++;
            }
            while (i < length && nums[i] == nums[i - 1]) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                length--;
            }
        }
        return ret;
    }
}

public class OJTest {
    public static void main(String[] args) {
        /*int[] nums = new int[10];
        nums[1] = 1;
        nums[2] = 2;
        System.out.println(Arrays.toString(nums));*/
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        System.out.println(list1.containsAll(list2));
    }
}

class mysql {
    create table goods (
            goods_id int,
            goods_name varchar(20),
    unitprice decimal(4, 2),
    provider varchar(20)
);

    create table customer (
            customer_id int,
            name varchar(20),
    address varchar(20),
    email varchar(20),
    sex varchar(5),
    card_id varchar(18)
);

    create purchase (
            order_id int,
            customer_id int,
            goods_id int,
            nums int
    );

    create table student2 (
            id int,
            name varchar(20),
    passward varchar(20),
    age int,
    sex varchar(5),
    brithday timestamp,
    score decimal(3,1),
    resum text
);


    create table goods (
            goods_id int,
            goods_name varchar(20),
    unit_price decimal(7,2),
    category varchar(50),
    provider varchar(50)
);

    create table customer (
            customer_id int,
            name varchar(20),
    address varchar(20),
    email varchar(20),
    sex varchar(5),
    card_id varchar(20)
);

    create table purchase (
            order_id int,
            customer_id int,
            goods_id int,
            nums int
    );
}
