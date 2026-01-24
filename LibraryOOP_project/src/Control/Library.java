package Control;

import Model.Book;
import Model.Status;

import java.util.ArrayList;

public class Library {

    // Control is stateless and only logical, however since we don't have DB now, we have this only one field here.
    private final ArrayList<Book> books = new ArrayList<>();


    private Book findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }


    public ArrayList<Book> getBooks() {
        return this.books;
    }


    public OperationResult add_book(String title, String author) {
        books.add( new Book(title, author));
        return new OperationResult(true, String.format("Added %s by %s", title, author));
    }


    public OperationResult borrow_book(String title) {
        Book book = findBookByTitle(title);

        if (book.getStatus() == Status.BORROWED) {
            return new OperationResult(false, "Error: It's already borrowed.");
        }

        book.borrow();
        return new OperationResult(true, String.format("Borrowed %s", title));
    }


    public OperationResult return_book(String title) {
        Book book = findBookByTitle(title);

        if (book.getStatus() == Status.FREE) {
            return new OperationResult(false, "Error: It's already free.");
        }

        book.return_book();
        return new OperationResult(true, String.format("Returned %s", title));
    }


    public String show_books() {
        StringBuilder sb = new StringBuilder();

        for (Book book : books) {
            sb.append(book.get_details());
            sb.append("\n");
        }

        return sb.toString();
    }

}
