
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.loadBooks("src/resources/data/books.txt");
        library.viewAllBooks();
    }
}
