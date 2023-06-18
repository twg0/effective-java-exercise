package item1;

public class Book {
    private String title;
    private long isbn;

    Book(long isbn) {
        if(isbn == 987654321L) {
            this.isbn = isbn;
            this.title = "Effective Java 3/E";
        } else if(isbn == 123456789L) {
            this.isbn = isbn;
            this.title = "객체지향의 사실과 오해";
        }
    }

    Book(String title) {
        if (title.equals("Effective Java 3/E")) {
            this.title = title;
            this.isbn = 987654321L;
        } else if (title.equals("객체지향의 사실과 오해")) {
            this.title = title;
            this.isbn = 123456789L;
        }
    }

    private Book(String title, long isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    static Book createByIsbn(long isbn) {
        if (isbn == 987654321L) {
            return new Book("Effective Java 3/E", isbn);
        } else if (isbn == 123456789L) {
            return new Book("객체지향의 사실과 오해", isbn);
        }

        throw new IllegalArgumentException("일치하는 책이 없습니다");
    }

    static Book createByTitle(String title) {
        if (title.equals("Effective Java 3/E")) {
            return new Book(title, 987654321L);
        } else if (title.equals("객체지향의 사실과 오해")) {
            return new Book(title, 123456789L);
        }

        throw new IllegalArgumentException("일치하는 책이 없습니다");
    }

    public static void main(String[] args) {

        // 개발자가 직관적으로 어떤 인자를 전달하는 것인지 알 수 있을까?
        Book book1 = new Book(987654321L);
        Book book2 = new Book("객체지향의 사실과 오해");

        // 생성자 오버로딩보다 직관적인 코드가 되었다.
        Book book3 = Book.createByIsbn(987654321L);
        Book book4 = Book.createByTitle("객체지향의 사실과 오해");
    }
}
