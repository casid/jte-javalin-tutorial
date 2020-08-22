package app.book;

import app.Page;
import io.javalin.http.Context;

import static app.App.bookDao;

public class BooksPage extends Page {
    public static final String PATH = "/books";

    public final Book[] books = bookDao.getAllBooks();

    public BooksPage(Context ctx) {
        super(ctx);
    }

    @Override
    public String getTemplate() {
        return "book/all.jte";
    }
}
