
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                String title = details[0];
                String author = details[1];
                int year = Integer.parseInt(details[2].trim());
                books.add(new Book(title, author, year));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByKeyword(String keyword) {
        // TODO missing code
        return null;
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
