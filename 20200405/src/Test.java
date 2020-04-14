import Book.*;
import User.*;

import java.util.Scanner;

public class Test {

    public static User forReady() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的名字 ! ");
        String name = scanner.next();
        byte Id = 0;
        do {
        System.out.println("请输入你的身份：1 管理员 0 普通用户");
        Id = scanner.nextByte();
        }while (Id != 1 && Id != 0);

        if(Id == 1) {
            return new AdminUser(name);
        }
            return new NormalUser(name);
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = forReady();
        while (true) {
            int choice = user.menu();
            user.doIOperations(choice, bookList);
        }
    }
}
