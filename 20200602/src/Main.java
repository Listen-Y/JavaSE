import java.util.*;
public class Main {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                StringBuffer buffer = new StringBuffer();
                for ( ; i < str.length() && isNum(str.charAt(i)); i++) {
                    buffer.append(str.charAt(i));
                }
                list.add(buffer.toString());
            }
            String ret = null;
            for (String s : list
                 ) {
                if (ret == null) {
                    ret = s;
                    continue;
                }
                if (s.length() > ret.length()) {
                    ret = s;
                }
            }
            System.out.println(ret);
        }
    }

    static boolean isNum(char c) {
        return c >= 48 && c <= 57;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        Queue<Integer> queue = new LinkedList<>();
    }
}

class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char key = A.charAt(i);
            if (key != '(' && key != ')') {
                return false;
            }
            if (key == '(') {
                stack.push(key);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            char ch = stack.peek();
            if (ch == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}