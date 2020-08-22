@import static jte.JteContext.*

@param app.index.NotFoundPage page

@layout.page(page = page, content = @`
    <h1>${localize("ERROR_404_NOT_FOUND")}</h1>
`)
