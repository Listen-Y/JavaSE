package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("输入你要删的书名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(bookList.getBooks(i).getNema().equals(name)) {
                for (int j = i; j < bookList.getUsedSize() - 1; j++) {
                    Book book = bookList.getBooks(j + 1);
                    bookList.setBook(j, book);
                }
                bookList.setUsedSize(bookList.getUsedSize() - 1);
                System.out.println("删除成功!");
                return;
            }
        }
        System.out.println("无此书!");
    }
}
