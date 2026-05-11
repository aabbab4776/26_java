package bookmarket;

import java.util.Scanner;

public class BookMarket {
    static Scanner scan = new Scanner(System.in);
    static Book[] books = new Book[5];
    static CartItem[] cart = new CartItem[10];
    static Customer customer;

    public static void main(String[] args) {
        makeBooks();
        inputCustomer();

        boolean run = true;

        while (run) {
            printMenu();
            int menu = scan.nextInt();
            scan.nextLine();

            if (menu == 1) {
                showCustomer();
            } else if (menu == 2) {
                showBookList();
            } else if (menu == 3) {
                showCart();
            } else if (menu == 4) {
                addCart();
            } else if (menu == 5) {
                removeCartItem();
            } else if (menu == 6) {
                clearCart();
            } else if (menu == 7) {
                showReceipt();
            } else if (menu == 8) {
                System.out.println("프로그램을 종료합니다.");
                run = false;
            } else {
                System.out.println("메뉴를 다시 선택하세요.");
            }
        }

        scan.close();
    }

    public static void makeBooks() {
        books[0] = new Book("ISBN1001", "자바프로그래밍", 25000, "황기태", "생능출판", "IT");
        books[1] = new Book("ISBN1002", "HTML CSS 입문", 18000, "김코딩", "한빛미디어", "웹");
        books[2] = new Book("ISBN1003", "파이썬 기초", 22000, "박파이썬", "이지스퍼블리싱", "프로그래밍");
        books[3] = new Book("ISBN1004", "정보보안 개론", 30000, "이보안", "인피니티북스", "보안");
        books[4] = new Book("ISBN1005", "운영체제 쉽게 배우기", 28000, "조운영", "길벗", "컴퓨터공학");
    }

    public static void inputCustomer() {
        System.out.println("BookMarket에 오신 것을 환영합니다.");
        System.out.print("이름을 입력하세요: ");
        String name = scan.nextLine();
        System.out.print("전화번호를 입력하세요: ");
        String phone = scan.nextLine();
        System.out.print("주소를 입력하세요: ");
        String address = scan.nextLine();
        customer = new Customer(name, phone, address);
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("======== BookMarket ========");
        System.out.println("1. 고객 정보 확인");
        System.out.println("2. 도서 목록 보기");
        System.out.println("3. 장바구니 보기");
        System.out.println("4. 장바구니에 도서 추가");
        System.out.println("5. 장바구니 도서 삭제");
        System.out.println("6. 장바구니 비우기");
        System.out.println("7. 영수증 보기");
        System.out.println("8. 종료");
        System.out.print("메뉴 선택: ");
    }

    public static void showCustomer() {
        System.out.println();
        System.out.println("고객 정보");
        customer.printCustomer();
    }

    public static void showBookList() {
        System.out.println();
        System.out.println("도서 목록");
        for (int i = 0; i < books.length; i++) {
            books[i].printBook();
        }
    }

    public static void showCart() {
        System.out.println();
        System.out.println("장바구니 목록");
        int total = 0;
        int count = 0;

        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null) {
                count++;
                cart[i].printCartItem(count);
                total += cart[i].getTotalPrice();
            }
        }

        if (count == 0) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("총 금액: " + total + "원");
        }
    }

    public static void addCart() {
        showBookList();
        System.out.print("추가할 도서 ID를 입력하세요: ");
        String bookId = scan.nextLine();

        int bookIndex = findBookIndex(bookId);

        if (bookIndex == -1) {
            System.out.println("해당 도서를 찾을 수 없습니다.");
            return;
        }

        System.out.print("수량을 입력하세요: ");
        int count = scan.nextInt();
        scan.nextLine();

        int cartIndex = findCartIndex(bookId);

        if (cartIndex != -1) {
            cart[cartIndex].count += count;
            System.out.println("이미 담긴 도서의 수량을 추가했습니다.");
            return;
        }

        int emptyIndex = findEmptyCartIndex();

        if (emptyIndex == -1) {
            System.out.println("장바구니가 가득 찼습니다.");
        } else {
            cart[emptyIndex] = new CartItem(books[bookIndex], count);
            System.out.println("장바구니에 추가되었습니다.");
        }
    }

    public static void removeCartItem() {
        showCart();
        System.out.print("삭제할 도서 ID를 입력하세요: ");
        String bookId = scan.nextLine();

        int cartIndex = findCartIndex(bookId);

        if (cartIndex == -1) {
            System.out.println("장바구니에 해당 도서가 없습니다.");
        } else {
            cart[cartIndex] = null;
            System.out.println("삭제되었습니다.");
        }
    }

    public static void clearCart() {
        for (int i = 0; i < cart.length; i++) {
            cart[i] = null;
        }
        System.out.println("장바구니를 비웠습니다.");
    }

    public static void showReceipt() {
        System.out.println();
        System.out.println("영수증");
        customer.printCustomer();
        showCart();
        System.out.println("이용해 주셔서 감사합니다.");
    }

    public static int findBookIndex(String bookId) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].bookId.equals(bookId)) {
                return i;
            }
        }
        return -1;
    }

    public static int findCartIndex(String bookId) {
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] != null && cart[i].book.bookId.equals(bookId)) {
                return i;
            }
        }
        return -1;
    }

    public static int findEmptyCartIndex() {
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
