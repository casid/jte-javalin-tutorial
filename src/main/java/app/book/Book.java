package app.book;

public class Book {
    public final String isbn;
    public final String title;
    public final String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getMediumCover() {
        return "http://covers.openlibrary.org/b/isbn/" + this.isbn + "-M.jpg";
    }

    public String getLargeCover() {
        return "http://covers.openlibrary.org/b/isbn/" + this.isbn + "-L.jpg";
    }
}
