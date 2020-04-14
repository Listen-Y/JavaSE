package User;

import Operation.*;

import java.util.Scanner;

public class NormalUser extends User {

    public NormalUser(String name) {
        super(name);
        this.iOperations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
        };
    }

    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("Hello"+ super.getName() +" 欢迎来到Knowledgable图书系统");
        System.out.println("1.查找图书");
        System.out.println("2.借阅书籍");
        System.out.println("3.归还书籍");
        System.out.println("0.退出系统");
        return scanner.nextInt();
    }
}
