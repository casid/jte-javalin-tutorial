@import static jte.JteContext.*

@param app.login.LoginPage page

@layout.page(page = page, content = @`
    <form id="loginForm" method="post">
        @if(page.authenticationFailed)
            <p class="bad notification">${localize("LOGIN_AUTH_FAILED")}</p>
        @elseif(page.authenticationSucceeded)
            <p class="good notification">${localize("LOGIN_AUTH_SUCCEEDED", page.getCurrentUser())}</p>
        @elseif(page.loggedOut)
            <p class="notification">${localize("LOGIN_LOGGED_OUT")}</p>
        @endif

        <h1>${localize("LOGIN_HEADING")}</h1>
        <p>${localize("LOGIN_INSTRUCTIONS", "/index")}</p>
        <label>${localize("LOGIN_LABEL_USERNAME")}</label>
        <input type="text" name="username" placeholder="${localize("LOGIN_LABEL_USERNAME")}" required value="">
        <label>${localize("LOGIN_LABEL_PASSWORD")}</label>
        <input type="password" name="password" placeholder="${localize("LOGIN_LABEL_PASSWORD")}" required value="">
        @if(page.loginRedirect != null)
            <input type="hidden" name="loginRedirect" value="${page.loginRedirect}">
        @endif
        <input type="submit" value="${localize("LOGIN_BUTTON_LOGIN")}">
    </form>
`)
