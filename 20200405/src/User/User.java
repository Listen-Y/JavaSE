package User;

import Book.BookList;
import Operation.IOperation;

abstract public class User {
    private String name;
    public IOperation[] iOperations;

    abstract public int menu();

    public void doIOperations(int choice, BookList bookList) {
        iOperations[choice].work(bookList);
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
