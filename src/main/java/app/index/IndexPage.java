package app.index;

import app.Page;
import app.book.Book;
import io.javalin.http.Context;

import java.util.List;

import static app.App.bookDao;
import static app.App.userDao;

public class IndexPage extends Page {

    public static final String PATH = "/index";

    private final List<String> userNames = userDao.getAllUserNames();
    private final Book bookOfTheDay = bookDao.getRandomBook();

    public IndexPage(Context ctx) {
        super(ctx);
    }

    @Override
    public String getTemplate() {
        return "index/index.jte";
    }

    public Iterable<String> getUserNames() {
        return userNames;
    }

    public Book getBookOfTheDay() {
        return bookOfTheDay;
    }

    public int getUserCount() {
        return userNames.size();
    }
}
