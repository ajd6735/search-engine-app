
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.loadBooks("src/resources/data/books.txt");
        library.viewAllBooks();

        SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
        System.out.println("After sorting by title:");
        library.viewAllBooks();

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a keyword to search (title, author, or year): ");

        String keyword = keyboard.nextLine();
        Book foundBook = library.searchBookByKeyword(keyword);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }

    }
}
