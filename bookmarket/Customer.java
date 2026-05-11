package bookmarket;

public class Customer {
    String name;
    String phone;
    String address;

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void printCustomer() {
        System.out.println("이름: " + name);
        System.out.println("전화번호: " + phone);
        System.out.println("주소: " + address);
    }
}
