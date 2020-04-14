package Operation;

import Book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你要借的书名");
        String name = scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(bookList.getBooks(i).getNema().equals(name)) {
                if(bookList.getBooks(i).getBrrower()) {
                    System.out.println("此书已借出!");
                    return;
                }
                bookList.getBooks(i).setBrrower(true);
                System.out.println("借书成功");
                return;
            }
        }
        System.out.println("无此书!!!");
    }
}
