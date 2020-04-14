package Operation;

import Book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("输入你要归还的书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(bookList.getBooks(i).getNema().equals(name)) {
                if( ! bookList.getBooks(i).getBrrower()) {
                    System.out.println("此书未被借出，无需归还!");
                    return;
                }
                bookList.getBooks(i).setBrrower(false);
                System.out.println("还书成功!");
                return;
            }
        }
        System.out.println("无此书!");
    }
}
