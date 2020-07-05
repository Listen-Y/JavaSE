import java.util.*;

public class Main {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String ret = scan.nextLine();
            String key = scan.nextLine();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < key.length(); i++) {
                set.add(key.charAt(i));
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < ret.length(); i++) {
                char ch = ret.charAt(i);
                if (!set.contains(ch)) {
                    builder.append(ch);
                }
            }
            System.out.println(builder.toString());
        }
    }
}
