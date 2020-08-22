package app.index;

import io.javalin.http.Handler;

public class IndexController {
    public static Handler serveIndexPage = ctx -> {
        IndexPage page = new IndexPage(ctx);
        page.render();
    };

    public static Handler serveNotFoundPage = ctx -> {
        NotFoundPage page = new NotFoundPage(ctx);
        page.render();
    };
}
