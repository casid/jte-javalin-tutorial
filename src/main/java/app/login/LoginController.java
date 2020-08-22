package app.login;

import io.javalin.http.Handler;

import static app.util.RequestUtil.removeSessionAttrLoggedOut;
import static app.util.RequestUtil.removeSessionAttrLoginRedirect;

public class LoginController {

    public static Handler serveLoginPage = ctx -> {
        LoginPage page = new LoginPage(ctx);
        page.loggedOut = removeSessionAttrLoggedOut(ctx);
        page.loginRedirect = removeSessionAttrLoginRedirect(ctx);
        page.render();
    };

    public static Handler handleLoginPost = ctx -> {
        LoginPage page = new LoginPage(ctx);

        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        if (!LoginService.authenticate(username, password)) {
            page.authenticationFailed = true;
            page.render();
        } else {
            ctx.sessionAttribute("currentUser", username);
            page.authenticationSucceeded = true;
            String loginRedirect = ctx.formParam("loginRedirect");
            if (loginRedirect != null) {
                ctx.redirect(loginRedirect);
            } else {
                page.render();
            }
        }
    };

    public static Handler handleLogoutPost = ctx -> {
        ctx.sessionAttribute("currentUser", null);
        ctx.sessionAttribute("loggedOut", "true");
        ctx.redirect(LoginPage.PATH);
    };

    // The origin of the request (request.pathInfo()) is saved in the session so
    // the user can be redirected back after login
    public static Handler ensureLoginBeforeViewingBooks = ctx -> {
        if (!ctx.path().startsWith("/books")) {
            return;
        }
        if (ctx.sessionAttribute("currentUser") == null) {
            ctx.sessionAttribute("loginRedirect", ctx.path());
            ctx.redirect(LoginPage.PATH);
        }
    };
}
