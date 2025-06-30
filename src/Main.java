
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.loadBooks("src/resources/data/books.txt");
        library.viewAllBooks();

        SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
        System.out.println("After sorting by title:");
        library.viewAllBooks();

    }
}
