package app.login;

import app.Page;
import io.javalin.http.Context;

public class LoginPage extends Page {
    public static final String PATH = "/login";

    public boolean loggedOut;
    public String loginRedirect;
    public boolean authenticationFailed;
    public boolean authenticationSucceeded;

    public LoginPage(Context ctx) {
        super(ctx);
    }

    @Override
    public String getTemplate() {
        return "login/login.jte";
    }
}
