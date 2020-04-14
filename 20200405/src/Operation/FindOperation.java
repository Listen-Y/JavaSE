package Operation;

import Book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("输入你要查找的书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(bookList.getBooks(i).getNema().equals(name)) {
                System.out.println("成功找到此书!");
                byte Id = 0;
                do {
                    System.out.println("是否查看此书所有信息  1 是  0  否");
                     Id = scanner.nextByte();
                }while (Id != 1 && Id != 0);
                if(Id == 1) {
                    System.out.println(bookList.getBooks(i).toString());
                }
                return;
            }
        }
        System.out.println("无此书!");
    }
}
