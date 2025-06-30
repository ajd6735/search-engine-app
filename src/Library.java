
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

        keyword = keyword.toLowerCase();
        int n = books.size();
        Book book = null;

        for(int i = 0; i < n; i++){
            Book b = books.get(i);
            String title = b.getTitle().toLowerCase();
            String author = b.getAuthor().toLowerCase();
            int year = b.getPublicationYear();

            if(keyword.equals(title) || keyword.equals(author)
            || keyword.equals(String.valueOf(year))){
                book = books.get(i);
            }
        }
        return book;
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
