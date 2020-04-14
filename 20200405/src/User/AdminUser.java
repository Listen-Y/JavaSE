package User;

import Operation.*;

import Operation.IOperation;

import java.util.Scanner;

public class AdminUser extends User {

    public AdminUser(String name) {
        super(name);
        this.iOperations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation(),
                new NeatenOperation()
        };
    }

    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("===Hello "+ super.getName() +" 欢迎来到Knowledgable图书系统===");
        System.out.println("1.查找图书");
        System.out.println("2.新增书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.打印书籍");
        System.out.println("5.整理书籍");
        System.out.println("0.退出系统");
        return scanner.nextInt();
    }
}
