package app.util;

import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class RequestUtil {

    @NotNull
    public static String getLocale(@NotNull Context ctx) {
        String locale = ctx.sessionAttribute("locale");
        if (locale == null) {
            return "en";
        }
        return locale;
    }

    public static boolean removeSessionAttrLoggedOut(@NotNull Context ctx) {
        String loggedOut = ctx.sessionAttribute("loggedOut");
        ctx.sessionAttribute("loggedOut", null);
        return loggedOut != null;
    }

    public static String removeSessionAttrLoginRedirect(@NotNull Context ctx) {
        String loginRedirect = ctx.sessionAttribute("loginRedirect");
        ctx.sessionAttribute("loginRedirect", null);
        return loginRedirect;
    }

}
