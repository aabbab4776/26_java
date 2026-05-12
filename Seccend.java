package day10;

public class Seccend {

    static class Book {
        private String title;

        protected Book(String title) {
            this.title = title;
        }

        protected String getTitle() {
            return title;
        }
    }

    static class EBook extends Book {
        private int inch;

        public EBook(String title, int inch) {
            super(title);
            this.inch = inch;
        }

        public void printInfo() {
            System.out.println("제목: " + getTitle());
            System.out.println("크기: " + inch + "인치");
        }

        public void text2Speech(int page) {
            System.out.println(page + "페이지를 읽습니다.");
        }
    }

    public static void main(String[] args) {
        EBook javaBook = new EBook("자바에센셜-전자책", 14);
        javaBook.printInfo();
        javaBook.text2Speech(3);
    }
}