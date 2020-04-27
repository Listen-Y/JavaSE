import java.util.Scanner;
class List {
    private char[] ch = new char[100];
    private int length = 0;
    public void add(char ch) {
        this.ch[length] = ch;
        length ++;
    }
    public boolean contains(char ch) {
        for( int i = 0; i < length; i ++) {
            if (this.ch[i] == ch) {
                return true;
            }
        }
        return false;
    }
    public void display() {
        for(int i = 0; i < length; i ++) {
            System.out.print(this.ch[i]);
        }
        System.out.println();
    }

    public void clear() {
        this.length = 0;
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            int length = str.length();
            List list = new List();
            for (int i = 0; i < length; i++) {
                if (!list.contains(str.charAt(i))) {
                    list.add(str.charAt(i));
                }
            }
            list.display();
            list.clear();
        }
    }
}
