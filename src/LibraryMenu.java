
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
            if (scanner.nextLine().equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Please select a numerical option: ");
            System.out.println("1 to view all books \n2 to sort books by keyword \n" +
                    "3 sort books by author \n4 sort books by publication year \n" +
                    "5 search for a book by its title \n6 exit the menu");
            int option = scanner.nextInt();
            String word;

            switch (option) {
                case 1:
                    logger.logViewAllBooks();
                    break;
                case 2:
                    word = scanner.nextLine();
                    logger.logSort(word);
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    break;
                case 3:
                    word = scanner.nextLine();
                    logger.logSort(word);
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    break;
                case 4:
                    System.out.println("Please enter a keyword");
                    word = scanner.nextLine();
                    logger.logSort(word);
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getPublicationYear));
                    break;
                case 5:
                    word = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(word);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    logger.logSort(word);
                    break;
                case 6:
                    System.out.println("Exiting the program. Good buy!");
                    break;
                default:
                    System.out.println("Invalid entry.");
            }
        }
    }
}
