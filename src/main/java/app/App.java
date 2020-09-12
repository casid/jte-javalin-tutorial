package app;

import app.book.BookController;
import app.book.BookDao;
import app.book.BookPage;
import app.book.BooksPage;
import app.index.IndexController;
import app.index.IndexPage;
import app.login.LoginController;
import app.login.LoginPage;
import app.user.UserDao;
import app.util.Filters;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import io.javalin.plugin.rendering.template.JavalinJte;

import java.nio.file.Path;

public class App {
    public static final boolean devSystem = System.getProperty("environment") == null;

    public static UserDao userDao;
    public static BookDao bookDao;

    public static void main(String[] args) {
        userDao = new UserDao();
        bookDao = new BookDao();

        Javalin app = Javalin.create(App::configure).start(7000);

        app.before(Filters.handleLocaleChange);
        app.before(LoginController.ensureLoginBeforeViewingBooks);
        app.get(IndexPage.PATH, IndexController.serveIndexPage);
        app.get(BooksPage.PATH, BookController.serveBooksPage);
        app.get(BookPage.PATH, BookController.serveBookPage);
        app.get(LoginPage.PATH, LoginController.serveLoginPage);
        app.post(LoginPage.PATH, LoginController.handleLoginPost);
        app.post("/logout", LoginController.handleLogoutPost);

        app.error(404, IndexController.serveNotFoundPage);
    }

    private static void configure(JavalinConfig config) {
        JavalinJte.configure(createTemplateEngine());
        config.addStaticFiles("/public");
    }

    private static TemplateEngine createTemplateEngine() {
        if (devSystem) {
            DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
            return TemplateEngine.create(codeResolver, ContentType.Html);
        } else {
            return TemplateEngine.createPrecompiled(Path.of("jte-classes"), ContentType.Html);
        }
    }
}
