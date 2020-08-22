package app.book;

import io.javalin.http.Handler;

public class BookController {
    public static Handler serveBooksPage = ctx -> {
        BooksPage booksPage = new BooksPage(ctx);
        booksPage.render();
    };

    public static Handler serveBookPage = ctx -> {
        BookPage bookPage = new BookPage(ctx);
        bookPage.render();
    };
}
