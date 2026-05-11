package bookmarket;

public class CartItem {
    Book book;
    int count;

    public CartItem(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public int getTotalPrice() {
        return book.price * count;
    }

    public void printCartItem(int number) {
        System.out.println(number + ". " + book.bookId + " | " + book.name + " | " + book.price + "원 | " + count + "권 | " + getTotalPrice() + "원");
    }
}
