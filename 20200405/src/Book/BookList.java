package Book;

import java.util.Arrays;

public class BookList {
    private Book[] books;
    private int usedSize;

    public BookList() {
        books = new Book[10];
        books[0] = new Book("HappyDay", "YaYa", 19.9f, "little");
        books[1] = new Book("SunDay", "XiaoXiao", 29.9f, "little");
        books[2] = new Book("EveryDay", "DiDi", 39.9f, "little");
        for (int i = 3; i < 10; i++) {
            books[i] = new Book();
        }
        usedSize = 3;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getBooks(int pos) {
        return books[pos];
    }

    public void setBooks(Book book) {
        this.books[usedSize] = book;
        this.usedSize++;
    }

    public void setBook(int pos, Book book) {
        this.books[pos] = book;
    }

    public void disPlay() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(books[i].toString());
        }
    }

    public void sortBookList() {
        Arrays.sort(this.books);
    }
}
