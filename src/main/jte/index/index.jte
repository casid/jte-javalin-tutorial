@import static jte.JteContext.*

@param app.index.IndexPage page

@layout.page(page = page, content = @`
    <h1>${localize("INDEX_HEADING")}</h1>
    <h2>${localize("INDEX_REGISTERED_USERS", page.getUserCount())}</h2>

    <ul>
        @for(var userName : page.getUserNames())
            <li>${userName}</li>
        @endfor
    </ul>

    <p>${localize("INDEX_PASSWORD_INFO")}</p>

    @tag.bookOfTheDay(page.getBookOfTheDay())
`)
