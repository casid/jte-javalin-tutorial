@import static jte.JteContext.*
@param app.book.BookPage page

@layout.page(page = page, content = @`
    @if(page.book != null)
        <h1>${page.book.title}</h1>
        <h2>${page.book.author}</h2>
        <div class="book">
            <div class="bookCover">
                <img src="${page.book.getLargeCover()}" alt="${page.book.title}">
            </div>
        </div>
    @else
        <h1>${localize("BOOKS_BOOK_NOT_FOUND")}</h1>
    @endif
`)
