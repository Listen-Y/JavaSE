package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("ok");
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("输入书名" + " 作者" + " 价格" + " 类型");
        book.setNema(scanner.next());
        book.setAuthor(scanner.next());
        book.setPrice(scanner.nextFloat());
        book.setType(scanner.next());
        bookList.setBooks(book);
        System.out.println("成功!!!");
    }
}
