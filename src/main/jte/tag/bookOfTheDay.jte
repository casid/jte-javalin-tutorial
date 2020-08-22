@import static jte.JteContext.*

@param app.book.Book book

@if(book != null)
    <h2>${localize("INDEX_BOOK_OF_THE_DAY_TEXT")}</h2>
    <div class="row row-2">
        <div class="col">
            <a href="/books/${book.isbn}">${localize("INDEX_BOOK_OF_THE_DAY_LINK", book.title, book.author)}</a>
        </div>
        <div class="col">
            <img src="${book.getLargeCover()}" alt="${book.title}">
        </div>
    </div>
@endif