package app.book;

import app.App;
import app.Page;
import io.javalin.http.Context;

public class BookPage extends Page {
    public static final String PATH = "/books/:isbn";

    public final Book book;

    public BookPage(Context ctx) {
        super(ctx);
        book = App.bookDao.getBookByIsbn(ctx.pathParam("isbn"));
    }

    @Override
    public String getTemplate() {
        return "book/one.jte";
    }
}
