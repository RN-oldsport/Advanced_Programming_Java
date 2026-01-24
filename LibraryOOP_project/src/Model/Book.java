package Model;

public class Book {
    private String title;
    private String author;
    private Status status;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = Status.FREE;
    }

    // getter setter
    public Status getStatus() {
        return this.status;
    }
    // according to method borrow, is setter needed? incaps says what?


    public String getTitle() {
        return this.title;
    }


    public void borrow() {
        // logic in Control. in Model only ---> borrow.
        this.status = Status.BORROWED;
    }


    public void return_book() {
        this.status = Status.FREE;
    }


    public String get_details() {
        String statusStr = (this.status == Status.BORROWED) ? "(Borrowed)" : "(Available)";

        return String.format("  %s by %s %s", this.title, this.author, statusStr);    }

}
