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
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int length = str.length();
        //ArrayList<char> list = new ArrayList<>();
        List list = new List();
        for(int i = 0; i < length; i++ ) {
            if( ! list.contains(str.charAt(i))) {
                list.add(str.charAt(i));
            }
        }
        list.display();
    }
}