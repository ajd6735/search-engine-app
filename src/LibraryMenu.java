
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please select a numerical option:");
            System.out.println("1 to view all books");
            System.out.println("2 to sort books by title");
            System.out.println("3 to sort books by author");
            System.out.println("4 to sort books by publication year");
            System.out.println("5 to search for a book by its title");
            System.out.println("6 to exit the menu");

            String input = scanner.nextLine();
            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please make a selection from the menu above.");
                continue;
            }

            String word;

            switch (option) {
                case 1:
                    logger.logViewAllBooks();
                    library.viewAllBooks();
                    break;
                case 2:
                    System.out.println("Please enter a book title to sort by title:");
                    word = scanner.nextLine();
                    logger.logSort(word);
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    break;
                case 3:
                    System.out.println("Please enter the author name to sort by name:");
                    word = scanner.nextLine();
                    logger.logSort(word);
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    break;
                case 4:
                    System.out.println("Please enter the publication year to sort by publication year:");
                    word = scanner.nextLine();
                    logger.logSort(word);
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getPublicationYear));
                    break;
                case 5:
                    System.out.println("Please enter a keyword to search:");
                    word = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(word);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    logger.logSearch(word);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbuy!");
                    return;
                default:
                    System.out.println("Invalid entry.");
                    break;
            }
        }
    }
}
