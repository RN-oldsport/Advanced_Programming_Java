package View;

import Control.Library;
import Control.OperationResult;
import Model.Book;

import java.util.Scanner;

public class View {
    Library library;

    public View(Library library) {
        this.library = library;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);
        String input;
        String command;

        while (sc.hasNext()) {
            String title;
            String author;

            OperationResult resultObject;

            input = sc.nextLine();
            String[] parts = input.split(" ",2);
            command = parts[0];
            String arguments;
            String[] info;


            switch (command) {

                case ("SHOW") :
                    System.out.println("Library Books");

                    System.out.println(library.show_books());
                    break;


                case ("BORROW") :
                    arguments = parts[1];
                    info = arguments.split("\"", 5);

                    title = info[1];

                    resultObject = library.borrow_book(title);

                    System.out.println(resultObject.getMessage());
                    break;


                case ("ADD") :
                    arguments = parts[1];
                    info = arguments.split("\"", 5);

                    title = info[1];
                    author = info[3];

                    resultObject = library.add_book(title, author);

                    System.out.println(resultObject.getMessage());
                    break;


                case ("RETURN") :
                    arguments = parts[1];
                    info = arguments.split("\"", 5);

                    title = info[1];

                    resultObject = library.return_book(title);

                    System.out.println(resultObject.getMessage());
                    break;
            }


        }
    }
}

