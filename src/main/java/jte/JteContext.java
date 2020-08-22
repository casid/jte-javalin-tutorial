package jte;

import app.util.Localizer;
import app.util.RequestUtil;
import gg.jte.Content;
import io.javalin.http.Context;

public final class JteContext {
    private static final ThreadLocal<JteContext> context = ThreadLocal.withInitial(JteContext::new);

    public static void init(Context ctx) {
        JteContext context = getContext();
        context.localizer = new JteLocalizer(Localizer.getInstance(RequestUtil.getLocale(ctx)));
    }

    public static Content localize(String key) {
        return getContext().localizer.localize(key);
    }

    public static Content localize(String key, Object ... params) {
        return getContext().localizer.localize(key, params);
    }

    private static JteContext getContext() {
        return context.get();
    }

    private JteLocalizer localizer;
}
