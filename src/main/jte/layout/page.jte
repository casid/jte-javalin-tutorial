@import static jte.JteContext.*
@import app.Page
@import gg.jte.Content

@param Page page
@param Content content

<html lang="${page.getLang()}">
<head>
    <title>${localize("COMMON_TITLE")}</title>
    <link rel="stylesheet" href="/main.css">
    <link rel="icon" href="/favicon.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
    <header>
        <nav>
            <a href="/index"><img id="logo" src="/img/logo.png" alt="Javalin Library"></a>
            <ul id="chooseLanguage">
                <form>
                    <li>
                        <button name="locale" value="de" style="background-image: url(/img/german.png);"></button>
                    </li>
                    <li>
                        <button name="locale" value="en" style="background-image: url(/img/english.png);"></button>
                    </li>
                </form>
            </ul>
            <ul id="menu">
                <li><a href="/books">${localize("COMMON_NAV_ALLBOOKS")}</a></li>
                @if(page.isUserLoggedIn())
                    <li>
                        <form method="post" action="/logout">
                            <button id="logout">${localize("COMMON_NAV_LOGOUT")}</button>
                        </form>
                    </li>
                @else
                    <li><a href="/login">${localize("COMMON_NAV_LOGIN")}</a></li>
                @endif
            </ul>
        </nav>
    </header>
    <main>
        <div id="content">
            ${content}
        </div>
    </main>
    <footer>
        ${localize("COMMON_FOOTER_TEXT")} ${localize("COMMON_FOOTER_RENDERED_TEXT", page.getRenderTime())}
    </footer>
</body>

</html>