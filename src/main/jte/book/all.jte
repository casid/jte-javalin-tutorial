@import static jte.JteContext.*
@param app.book.BooksPage page

@layout.page(page = page, content = @`
    <h1>${localize("BOOKS_HEADING_ALL")}</h1>
    <div class="row row-3">
        @for(var book : page.books)
            <div class="col">
                <a class="book" href="/books/${book.isbn}">
                    <div class="bookCover">
                        <img src="${book.getMediumCover()}" alt="${book.title}">
                    </div>
                    ${localize("BOOKS_CAPTION", book.title, book.author)}
                </a>
            </div>
        @endfor
    </div>
`)
