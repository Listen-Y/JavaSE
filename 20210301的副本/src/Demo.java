import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        /**
         * 1. advertiser_id = ‘3’
         * 2. start_time = ‘2021-01-01'
         * 3. end_time = ‘2021-01-02'
         * 4. page_no = 1
         * 5. page_size = 10
         * 6. ts = 1611905162
         * 7. sign = ‘683f275e-a4d8-4621-a7db-72ace90aefa6'
         */
        List<Object> params = new ArrayList<>();
        params.add("advertiser_id = ‘3’");
        params.add("start_time = ‘2021-01-01'");
        params.add("end_time = ‘2021-01-02'");
        params.add("ts = 1611905162");
        String collect = params.stream().filter(Objects::nonNull)
                .map(Object::toString)
                .sorted()
                .collect(Collectors.joining("&"));
        System.out.println(collect);

    }
}
