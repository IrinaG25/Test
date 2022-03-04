public class Book {
    int bookCode;
    String name, author;
    int quantity;
    String description;

    @Override
    public String toString() {
        return String.valueOf(bookCode) + " " + String.valueOf(quantity) + " " + name + " " + author + "\n";

    }

    //Constructor
    public Book(int bookCode, int quantity, String name, String author,String description) {
        this.bookCode = bookCode;
        this.quantity = quantity;
        this.name = name;
        this.author = author;
        this.description = description;
    }

}
