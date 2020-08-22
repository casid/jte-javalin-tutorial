package app.index;

import app.Page;
import app.book.Book;
import io.javalin.http.Context;

import java.util.List;

import static app.App.bookDao;
import static app.App.userDao;

public class NotFoundPage extends Page {

    public NotFoundPage(Context ctx) {
        super(ctx);
    }

    @Override
    public String getTemplate() {
        return "index/notFound.jte";
    }
}
