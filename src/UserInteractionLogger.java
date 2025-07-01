
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class UserInteractionLogger {

    private static final String LOG_FILE = "src/resources/data/user_interactions.log";

    // Method to log search interactions
    public void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }

    // Method to log sorting interactions
    public void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }

    // Method to log viewing all books
    public void logViewAllBooks() {
        log("Viewed all books");
    }

    // Generic method to log messages with a timestamp
    public void log(String message) {
    // TODO - missing code.
        try{
            FileWriter fw = new FileWriter(LOG_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            LocalDateTime date = LocalDateTime.now();
            bw.write("[" + date.toString() + "] " + message);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("The log file is not found or cannot be written.");
            e.printStackTrace();
        }
    }

}
