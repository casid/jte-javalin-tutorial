package app;

import app.util.RequestUtil;
import io.javalin.http.Context;
import jte.JteContext;

import java.util.Collections;

public abstract class Page {

    protected final Context ctx;

    private final long created = System.nanoTime();
    private String currentUser;

    public Page(Context ctx) {
        this.ctx = ctx;
    }

    public abstract String getTemplate();

    public String getCurrentUser() {
        if (currentUser == null) {
            currentUser = ctx.sessionAttribute("currentUser");
        }
        return currentUser;
    }

    public boolean isUserLoggedIn() {
        return getCurrentUser() != null;
    }

    public String getLang() {
        return RequestUtil.getLocale(ctx);
    }

    public String getRenderTime() {
        long duration = System.nanoTime() - created;
        double millis = duration / 1000000.0;

        return Math.round(millis * 1000.0) / 1000.0 + "ms";
    }

    public void render() {
        JteContext.init(ctx);
        ctx.render(getTemplate(), Collections.singletonMap("page", this));
    }
}
