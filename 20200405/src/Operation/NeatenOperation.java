package Operation;

import Book.BookList;

public class NeatenOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        bookList.sortBookList();
    }
}
