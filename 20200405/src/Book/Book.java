package Book;

public class Book implements Comparable<Book> {
    private String nema;
    private String author;
    private Float price;
    private String type;
    private Boolean brrower;

    public Book(String nema, String author, Float price, String type) {
        this.nema = nema;
        this.author = author;
        this.price = price;
        this.type = type;
        this.brrower = false;
    }

    public Book() {
        this.nema = "0";
        this.author = "0";
        this.price = 0f;
        this.type = "0";
        this.brrower = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nema= '" + nema + '\'' +
                ", author= '" + author + '\'' +
                ", price= " + price +
                ", type= '" + type + '\'' +
                (brrower ? " 已借出" : " 未借出") +
                '}';
    }

    public String getNema() {
        return nema;
    }

    public void setNema(String nema) {
        this.nema = nema;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getBrrower() {
        return brrower;
    }

    public void setBrrower(Boolean brrower) {
        this.brrower = brrower;
    }

    @Override
    public int compareTo(Book o) {
        return (int) (o.getPrice() - this.getPrice());
    }
}
