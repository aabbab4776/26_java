package bookmarket;

public class Book {
    String bookId;
    String name;
    int price;
    String author;
    String publisher;
    String category;

    public Book(String bookId, String name, int price, String author, String publisher, String category) {
        this.bookId = bookId;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    public void printBook() {
        System.out.println(bookId + " | " + name + " | " + price + "원 | " + author + " | " + publisher + " | " + category);
    }
}
