import View.View;
import Control.Library;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        View view = new View(library); // DI principles

        view.start();
    }
}
