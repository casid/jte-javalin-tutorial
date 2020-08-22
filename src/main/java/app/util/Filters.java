package app.util;

import io.javalin.http.Handler;

public class Filters {
    // Locale change can be initiated from any page
    // The locale is extracted from the request and saved to the user's session
    public static Handler handleLocaleChange = ctx -> {
        String queryLocale = ctx.queryParam("locale");
        if (queryLocale != null) {
            ctx.sessionAttribute("locale", queryLocale);
            ctx.redirect(ctx.path());
        }
    };
}
