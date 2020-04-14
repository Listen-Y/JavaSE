package Operation;

import Book.BookList;

import java.util.Arrays;

public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        bookList.disPlay();
    }
}
